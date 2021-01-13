import java.io.File;

public class FlySunDemo {

    public boolean callArgumentInstance(File file) {
        return file.exists();
    }

    public boolean callArgumentInstance(String path) {
        File file = new File(path);
        return file.exists();
    }

    public boolean callFinalMethod(ClassDependency refer) {
        return refer.isAlive();
    }

    public boolean callStaticMethod() {
        return ClassDependency.isAlive2();
    }

    public boolean callPrivateMethod() {
        return isAlive();
    }

    private boolean isAlive() {
        return false;
    }

    public String callSystemStaticMethod(String str) {
        return System.getProperty(str);
    }
}
