package cn.hdj.jvm.memoryarea;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args : -Xmx20m -Xms20m -XX：+HeapDumpOnOutOf-MemoryError
 */
public class HeadOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
