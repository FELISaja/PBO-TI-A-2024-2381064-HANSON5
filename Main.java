import java.util.Scanner;

public class Main {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("before delete");
//        addTodoList("menulis");
//        addTodoList("menggambar");
//        addTodoList("membaca");
//        showTodoList();
//        removeTodoList(2);
//        System.out.println("after delet");
        showMainMenu();
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todos[i] != null) {
                System.out.println((i + 1) + "." + todo);
            }
        }
    }

    public static void addTodoList(String todo) {

        boolean isFull = true;
        isFull = resizeArrayIfFull(isFull);

        if (isFull) {
            resizeArrayToTwoTimeBigger();
        }

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    private static void resizeArrayToTwoTimeBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) {
            todos[i] = temp[i];
        }
    }

    private static boolean resizeArrayIfFull(boolean isFull) {
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public static boolean removeTodoList(Integer number) {
        if (isSelectedTodoNotValid(number)) return false;

        for (int i = number - 1; i < todos.length; i++) {
            //if todo is the last element
            if (i == (todos.length - 1)) {
                todos[i] = null;
            } else {
                // replace with the element on the ridght
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectedTodoNotValid(Integer number) {
        if (number <= 0) {
            return true;
        }

        if (number - 1 > todos.length - 1) {
            return true;
        }

        if (todos[number - 1] == null) {
            return true;
        }
        return false;
    }

    public static boolean editTodoList(Integer number, String newTodo) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. tambah");
            System.out.println("2. hapus");
            System.out.println("3. edit");
            System.out.println("4. kelluar");
            String selectedmenu = scanner.nextLine();
            switch (selectedmenu) {
                case "1":
                    //showMenuTodoList();
                    System.out.println("menu add todo list");
                    break;
                case "2":
                    //showMenuTodoList();
                    System.out.println("menu add todo list");
                    break;
                case "3":
                    //showMenuTodoList();
                    System.out.println("menu add todo list");
                    break;
                case "4":
                    //showMenuTodoList();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public static String input(String info) {
        System.out.println(info + ":");
        String data = scanner.nextLine();
        return data;
    }

    public static void showMenuAddTodoList() {
        System.out.println("menambah Todo List");
        String todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void showmenuremovetodolist(){
        System.out.println("MENGHAPUS TODO LIST");
        String todoYangDipilih =input("Nomor Todo yang di hapus (x jika batal");
        if (todoYangDipilih.equals("x")){
            //batal
        } else{
            boolean success = removeTodoList(Integer.valueOf(todoYangDipilih));
            if (!success){
                System.out.println("gagal menghapus todo list :" + todoYangDipilih);
            }
        }
    }
    public static void showmenuEditTodoList(){
        System.out.println("MENGEDIT TODO LIST");
        String selectedTodo = input("masukkannomor todo (x jika batal)");
        if (selectedTodo.equals("x")){
            return;
        }
        String newTodo = input("Masukkan todo yang baru (x jika batal)");
        if (newTodo.equals("x")){
            return;
        }
        boolean isEditTodoSuccess = editTodoList(Integer.valueOf(selectedTodo), newTodo);
        if (isEditTodoSuccess){
            System.out.println("Berhasil mengedit todo");
        } else {
            System.out.println("Gagal mengedit todo");

        }
    }
}