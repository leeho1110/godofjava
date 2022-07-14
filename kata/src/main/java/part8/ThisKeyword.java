package part8;

public class ThisKeyword {
    private String field;

    public ThisKeyword(String field) {
        // field = field; // 변수명이 동일한 상태에서 this 키워드없이는 인스턴스 필드에 할당 불가
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public static void main(String[] args) {
        ThisKeyword instance = new ThisKeyword("field");
        instance.getField().length(); // java.lang.NullPointerException
    }
}
