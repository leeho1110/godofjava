package part21;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkGenericDTO();
    }

    private void checkGenericDTO() {
        CastingDtoWithGeneric<String> dto1 = new CastingDtoWithGeneric<>();
        dto1.setObject(new String());
        String object1 = dto1.getObject();

        CastingDtoWithGeneric<StringBuffer> dto2 = new CastingDtoWithGeneric<>();
        dto2.setObject(new StringBuffer());
        StringBuffer object2 = dto2.getObject();

        CastingDtoWithGeneric<StringBuilder> dto3 = new CastingDtoWithGeneric<>();
        dto3.setObject(new StringBuilder());
        StringBuilder object3 = dto3.getObject();
    }
}
