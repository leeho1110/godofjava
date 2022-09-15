package part27;

import java.io.Serializable;

public class SerialDto implements Serializable {

    static final Long serialVersionUID = 1L;

    private String bookName;
    transient private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;

    private String bookType = "IT";

    public SerialDto(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDto{" +
                "bookName='" + bookName + '\'' +
                ", bookOrder=" + bookOrder +
                ", bestSeller=" + bestSeller +
                ", soldPerDay=" + soldPerDay +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
