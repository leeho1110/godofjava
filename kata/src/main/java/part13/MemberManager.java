package part13;

public interface MemberManager {

    public boolean addMember(MemberDTO memberDTO);
    public boolean removeMember(String name, String phone);
    public boolean updateMember(MemberDTO memberDTO);
}
