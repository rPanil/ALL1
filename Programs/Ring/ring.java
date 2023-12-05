import java.util.Scanner;

public class pdc1 {
    static final int MAX = 20;
    static int[] list = new int[MAX];
    static int n, cdr;

    public static void display() {
        System.out.print("\nProcesses->");
        for (int i = 1; i <= n; i++)
            System.out.print("\t" + i);
        System.out.print("\nAlive-->");
        for (int i = 1; i <= n; i++)
            System.out.print("\t" + list[i]);
        System.out.println("\nCoordinator is::" + cdr);
    }

    public static void ring() {
        Scanner scanner = new Scanner(System.in);
        int[] msg = new int[20];
        int ch, crash, activate, gid, flag=0, subcdr=0;

        do {
            System.out.print("\n1.Crash\n2.Activate\n3.Display\n4.Exit\nEnter Your choice::");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("\nEnter Process no. to Crash::");
                    crash = scanner.nextInt();
                    if (list[crash] != 0)
                        list[crash] = 0;
                    else {
                        System.out.println("\nProcess is already dead!!");
                        break;
                    }

                    do {
                        System.out.print("\nEnter election generator id::");
                        gid = scanner.nextInt();
                        if (gid == cdr)
                            System.out.print("\nEnter a valid generator id::");
                    } while (gid == crash);

                    flag = 0;
                    int k = 1;
                    if (crash == cdr) {
                        msg[k++] = gid;
                        for (int i = (gid + 1) % n; i != gid; i = (i + 1) % n) {
                            if (list[i] != 0) {
                                System.out.println("\nMessage is sent to " + i + " k=" + k);
                                msg[k++] = i;
                                System.out.println("Response is sent from " + i + " to " + gid);
                            }
                        }
                        subcdr = 0;
                        for (int i = 1; i < k; i++) {
                            System.out.println("msg::" + msg[i]);
                            if (subcdr < msg[i]) {
                                subcdr = msg[i];
                            }
                        }
                        cdr = subcdr;
                    }
                    display();
                    break;

                case 2:
                    System.out.print("\nEnter Process no. to Activated::");
                    activate = scanner.nextInt();
                    if (list[activate] == 0)
                        list[activate] = 1;
                    else {
                        System.out.println("\nProcess is already active!!");
                        break;
                    }

                    if (activate == n) {
                        cdr = n;
                        break;
                    }

                    for (int i = activate + 1; i <= n; i++) {
                        System.out.println("\nMessage is sent from " + activate + " to " + i);
                        if (list[i] != 0) {
                            subcdr = i;
                            System.out.println("Response is sent from " + i + " to " + activate);
                            flag = 1;
                        }
                    }

                    if (flag == 1) {
                        cdr = subcdr;
                    } else {
                        cdr = activate;
                    }
                    display();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    break;
            }
        } while (ch != 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter no. of process::");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter Process " + i + " is Alive or not(0/1)::");
            list[i] = scanner.nextInt();
            if (list[i] != 0)
                cdr = i;
        }

        display();
        ring();
    }
}

