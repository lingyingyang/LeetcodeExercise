package hash;

@lombok.Data
public class Data {
    public static void main(String[] args) {
        Data data = new Data("name", "value");
        System.out.println(data.hashCode());
    }

    private String name;
    private String value;

    public Data(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
