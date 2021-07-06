import builder.BusBuilder;
import builder.CarBuilder;
import builder.MotoBuilder;
import builder.TransportBuilder;
import model.Transport;

import java.util.Scanner;

/* ------- ШАГ 6 -------
 *
 */
public class TransportLine {
    public static void main(String[] args) {
        boolean isContinue = true;
        do {
            //объект для работы с командной строкой
            Scanner sc = new Scanner(System.in);
            //getType(sc);
            //создаем объект транспорта конкретного типа с пустыми параметрами
            TransportBuilder<?> builder = getBuilder(getType(sc));

            //заполняем новый объект параметром vin
            builder.vin(readString(sc,"Введите VIN транспорта"))
                    .maxSpeed(readInt(sc, "введите скорость", 380));
            builder.height(readInt(sc,"введите высоту",300));
            //и т.д.

            //генерируем объект с его наследниками
            Transport transport = builder.build();
            showInfo(transport);

            //System.out.println(builder.getClass());
        } while (isContinue);
    }

    //работаем с билдером, дженериком и в зависимости от типа идем у нужный класс билдера дженерика
    //создаем объект транспорта с пустыми параметрами
    private static TransportBuilder<?> getBuilder(int type) throws IllegalArgumentException {
        switch (type){
            case 1 : return new CarBuilder();
            case 2 : return new BusBuilder();
            case 3 : return new MotoBuilder();
            default: throw new  IllegalArgumentException("Не правильный тип Transport");
        }
    }

    //метод транслирует сканер на проверку в readInt и предложение варианта, подсказки
    private static int getType(Scanner sc) {
        return readInt(sc,
                      "Выберите тип транспорта: 1 - легковая, 2 - автобус, 3 - мото",
                      3);
    }

    //метод проверки диапазона выбора типа транспорта и только цифры.
    //возвращает переданную на вход цифру
    private static int readInt(Scanner scanner, String text, int max){
        int result = 0;
        boolean isContinue = true;

        do {
            System.out.println(text);
            try {
                String value = scanner.nextLine();
                result = Integer.parseInt(value);
            } catch (Exception e) {
                System.out.println("Ожадается ввод цифры!");
                continue;
            }
            isContinue = result <= 0 || result > max;
            if (isContinue){
                System.out.println("Не удовлетворяет условию: мин - 1 и макс (включая) - " + max);
            }
        } while (result <=0 || result > max);

        return result;
    }

    //метод чтения параметра vin из командной строки и показываем подсказку для ввода
    //тип данный другой чем у остальных
    private static String readString(Scanner sc, String text){
        String vin = "";
        do {
            System.out.println(text);
            vin = sc.nextLine();
        } while (vin.isEmpty());

        return vin;
    }

    //
    public static void showInfo(Transport transport){
        System.out.println("Создано транспортное средство:\n"
                            + "\nТип: " + transport.getType()
                            + "\nVIN: " + transport.getVin()
                            + "\nДата сборки: " + transport.getCreateDate()
        + "\nДлина: " + transport.getLength()
        + "\nШирина: " + transport.getWidth()
        + "\nВысота: " + transport.getHeight()
        + "\nСкорость: " + transport.getMaxSpeed());
    }
}
