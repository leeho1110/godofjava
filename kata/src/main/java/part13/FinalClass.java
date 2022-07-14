package part13;

public final class FinalClass {

    final MemberDTO memberDTO;

    public FinalClass(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public final void finalMethod(final String param){
//        param = "final"; // Cannot assign a value to final variable 'param'
    }
}
