
package Tshop;

public class ReservationCanceled extends AbstractEvent {

    private Long reservationId;
    private Long productId;

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
