package builder;

import model.Transport;

import java.time.ZonedDateTime;

/* ------- ШАГ 4 -------
 * ограничим класс нашим Transport, дженерик. Это параметризарованный класс с типом Т, не надо передавать кучу параметров на вход
 * создаем абстрактный класс, т.е. он не может создавать ни объекты, ни экземпляры
 * методы, которые возвращают билд для создания цепочки. Чтоб все параметры легли/связались в один билд, тип транспорта
 * и описываем каждый параметр в виде дженерика
 * Метод build() для генерации объекта. Builder используется для построения потока. Возвращает построенный поток.
 */
public abstract class TransportBuilder<T extends Transport> {
    protected String vin;
    protected Integer maxSpeed;
    protected Integer width;
    protected Integer height;
    protected Integer length;

    public TransportBuilder<T> vin(String vin) {
        this.vin = vin;
        return this;
    }

    public TransportBuilder<T> maxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public TransportBuilder<T> width(Integer width) {
        this.width = width;
        return this;
    }

    public TransportBuilder<T> height(Integer height) {
        this.height = height;
        return this;
    }

    public TransportBuilder<T> length(Integer length) {
        this.length = length;
        return this;
    }

    //объявляем для типа Т абстрактный класс с мотодом build, и возвращаем в тип Т наследников Transport
    public abstract T build();
}
