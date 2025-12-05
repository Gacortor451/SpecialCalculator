public class Calculator {
    String name;
    double cache;

    public Calculator(String nombre) {
        this.name = nombre;
        this.cache = 0;
    }

    // region getter and setter
    public String getName() {
        return this.name;
    }

    public double getCache() {
        return this.cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    // endregion

    public static void showOptionsMenu() {
        System.out.println("""
        | Available options:
        | 1. Add: num + num
        | 2. Subtract: num - num
        | 3. Multiply: num * num
        | 4. Divide: num / num""");
    }

    public void clearCache() {
        this.cache = 0;
    }

    @Override
    public String toString() {
        return (this.name + ". Cache = " + this.cache);
    }
}
