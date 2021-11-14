package hello.core.order;

/**
 * create OrderService Interface
 */

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice );
}
