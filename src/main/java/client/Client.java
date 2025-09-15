package client;

import app.controller.MemberController;
import app.controller.TrainerController;

import java.util.Scanner;

public class Client {

    private static TrainerController trainerController;
    private static MemberController memberController;
    private static Scanner scanner;

    public static void main(String[] args) {

        try {
            // Создаём объекты контроллеров для взаимодействия с приложением
            trainerController = new TrainerController();
            memberController = new MemberController();
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        while (true) {
            System.out.println("Выберите желаемую операцию:");
            System.out.println("1 - операции с тренерами");
            System.out.println("2 - операции с пользователями");
            System.out.println("0 - выход");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    trainerOperations();
                    break;
                case "2":
                    memberOperations();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }

    public static void trainerOperations() {
        while (true) {
            try {
                System.out.println("Выберите желаемую операцию с тренерами:");
                System.out.println("1 - сохранить тренера");
                System.out.println("2 - получить всех тренеров");
                System.out.println("3 - получить тренера по идентификатору");
                System.out.println("4 - удалить тренера по идентификатору");
                System.out.println("5 - удалить тренера по имени");
                System.out.println("6 - восстановить тренера по идентификатору");
                System.out.println("7 - восстановить тренера имени");
                System.out.println("8 - получить количество тренеров");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите имя тренера");
                        String name = scanner.nextLine();
                        System.out.println(trainerController.save(name));
                        break;
                    case "2":
                        trainerController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите идентификатор");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(trainerController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.deleteById(id);
                        break;
                    case "5":
                        System.out.println("Введите имя тренера");
                        name = scanner.nextLine();
                        trainerController.deleteByName(name);
                        break;
                    case "6":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.restoreById(id);
                        break;
                    case "7":
                        System.out.println("Введите имя тренера");
                        name = scanner.nextLine();
                        trainerController.restoreByName(name);
                    case "8":
                        System.out.println("Количество тренеров - " + trainerController.getTrainersNumber());
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void memberOperations() {
        while (true) {
            try {
                System.out.println("Выберите желаемую операцию с пользователями:");
                System.out.println("1 - сохранить пользователя");
                System.out.println("2 - получить всех пользователей");
                System.out.println("3 - получить пользователя по идентификатору");
                System.out.println("5 - удалить пользователя по идентификатору");
                System.out.println("6 - удалить пользователя по имени");
                System.out.println("7 - восстановить пользователя по идентификатору");
                System.out.println("8 - восстановить пользователя по имени");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите имя пользователя");
                        String name = scanner.nextLine();
                        System.out.println(memberController.save(name));
                        break;
                    case "2":
                        memberController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите идентификатор");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(memberController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.deleteById(id);
                        break;
                    case "5":
                        System.out.println("Введите имя пользователя");
                        name = scanner.nextLine();
                        memberController.deleteByName(name);
                        break;
                    case "6":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.restoreById(id);
                        break;
                    case"7":
                        System.out.println("Введите имя пользователя");
                        name = scanner.nextLine();
                        memberController.restoreByName(name);
                    case "8":
                        System.out.println("Количество пользователя - " + memberController.getMembersNumber());
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}