public class Ch01Intro {
  public static void main(String[] args) {
    int i = 13;
    byte b = (byte) i;
    i = (int) 13.456;

    System.out.println(i);
    System.out.println(b);
    System.out.println(i == b);
  }
}
