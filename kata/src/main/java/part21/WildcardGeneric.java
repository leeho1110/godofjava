package part21;

public class WildcardGeneric<W> {
    W wildcard;

    public void setWildcard(W wildcard){
        this.wildcard = wildcard;
    }

    public W getWildcard(){
        return this.wildcard;
    }
}
