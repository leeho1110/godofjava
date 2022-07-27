package part21;

import java.io.Serializable;

public class CastingDtoWithGeneric<GodOfJava> implements Serializable {
    private GodOfJava object;

    public GodOfJava getObject() {
        return object;
    }

    public void setObject(GodOfJava object) {
        this.object = object;
    }
}
