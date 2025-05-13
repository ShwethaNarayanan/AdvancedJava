package patterns;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum OrderStatus {
	PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
}

class Orders {
	private int orderId;
	private LocalDate orderDate;
	private OrderStatus status;
	private Double totalAmount;
	private int totalNoItems;

	protected Orders(int orderId, LocalDate orderDate, OrderStatus status, Double totalAmount, int totalNoItems) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.status = status;
		this.totalAmount = totalAmount;
		this.totalNoItems = totalNoItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalNoItems() {
		return totalNoItems;
	}

	public void setTotalNoItems(int totalNoItems) {
		this.totalNoItems = totalNoItems;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", status=" + status + ", totalAmount="
				+ totalAmount + ", totalNoItems=" + totalNoItems + "]";
	}

}

public class Streams8 {

	public static void main(String[] args) {

		Orders o1 = new Orders(1, LocalDate.now().minusDays(4), OrderStatus.CONFIRMED, 3561.0, 10);
		Orders o2 = new Orders(2, LocalDate.now().minusDays(1), OrderStatus.PENDING, 465.0, 20);
		Orders o3 = new Orders(3, LocalDate.now().minusDays(2), OrderStatus.SHIPPED, 566.0, 30);
		Orders o4 = new Orders(4, LocalDate.now().minusDays(3), OrderStatus.SHIPPED, 356.0, 15);
		Orders o5 = new Orders(5, LocalDate.now().minusDays(5), OrderStatus.DELIVERED, 465.0, 10);
		Orders o6 = new Orders(6, LocalDate.now().minusDays(1), OrderStatus.CONFIRMED, 790.0, 8);

		List<Orders> ordersList = Arrays.asList(o1, o2, o3, o4, o5, o6);

		// Find sum of all prices
		Double sum_totalAmt = ordersList.stream().collect(Collectors.summingDouble(Orders::getTotalAmount));

		System.out.println(sum_totalAmt);

		// Find Average of totalAmount
		Double avg = ordersList.stream().collect(Collectors.averagingDouble(Orders::getTotalAmount));
		System.out.println(avg);

		// Partition the table based on condition
		Map<Boolean, List<Orders>> amtgt700 = ordersList.stream()
				.collect(Collectors.partitioningBy(order -> order.getTotalAmount() > 700));

		System.out.println(amtgt700);
		amtgt700.forEach((ans, list) -> {
			System.out.println(ans);
			list.forEach(System.out::println);
		}

		);

		// Group and list based on status
		Map<OrderStatus, List<Orders>> collectList = ordersList.stream()
				.collect(Collectors.groupingBy(Orders::getStatus, TreeMap::new, Collectors.toList()));
		collectList.forEach((status, list) -> {
			System.out.println(status);
			list.forEach(System.out::println);
		});
		// Group and list based on total amount
		Map<Double, Long> collect = ordersList.stream()
				.collect(Collectors.groupingBy(Orders::getTotalAmount, Collectors.counting()));
		collect.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		// Sort based on status
		ordersList.stream().sorted(Comparator.comparing(Orders::getStatus))
				.map(order -> order.getOrderId() + " " + order.getStatus()).forEach(System.out::println);
		;

		// Find minimum order amount
		Optional<Orders> min = ordersList.stream().min(Comparator.comparing(Orders::getTotalAmount));
		System.out.println(min.get());

		// Fetch all the status and delimit them with a comma
		String collect2 = ordersList.stream().map(order -> String.valueOf(order.getOrderId()))
				.collect(Collectors.joining(", "));
		System.out.println(collect2);

		// Fetch the records and sort the items based on total number of items
		ordersList.stream().sorted(Comparator.comparingInt(Orders::getTotalNoItems).reversed())
				.forEach(System.out::println);

		// Group items based on no. of items
		Map<Integer, Long> collectByItems = ordersList.stream()
				.collect(Collectors.groupingBy(Orders::getTotalNoItems, Collectors.counting()));

		collectByItems.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println(collectByItems);

		// Group items by no. of Items along with their list
		Map<Integer, List<Orders>> collectItemsList = ordersList.stream().collect(Collectors.groupingBy(
				Orders::getTotalNoItems, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.toList()));

		System.out.println(collectItemsList);

//		collectItemsList.forEach((noItems, list) -> {
//			System.out.println(noItems);
//			list.forEach(System.out::println);
//		});

	}

}
