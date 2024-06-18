import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        System.out.println("Para começar, insira seu nome:");
        String employeeName = scanner.nextLine();
        Employee employee = new Employee(employeeName);

        while (true) {
            System.out.println("\nOlá, " + employee.getName() + ". O que você gostaria de fazer?");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Mostrar Inventário");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (escolha) {
                case 1:
                    System.out.println("Insira o nome do produto:");
                    String productNameToAdd = scanner.nextLine();
                    Product productToAdd = new Product(productNameToAdd);
                    System.out.println("Insira a quantidade para ser adicionada:");
                    int quantityToAdd = scanner.nextInt();
                    inventory.addProduct(productToAdd, quantityToAdd);
                    break;
                case 2:
                    System.out.println("Insira o nome do produto:");
                    String productNameToRemove = scanner.nextLine();
                    Product productToRemove = new Product(productNameToRemove);
                    System.out.println("Insira a quantidade para ser removida:");
                    int quantityToRemove = scanner.nextInt();
                    inventory.removeProduct(productToRemove, quantityToRemove);
                    break;
                case 3:
                    inventory.displayInventory();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}