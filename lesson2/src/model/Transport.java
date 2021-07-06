package model;

import java.time.ZonedDateTime;
/* ------- ШАГ 1 -------
* создаем абстрактный класс, т.е. он не может создавать ни объекты, ни экземпляры
* прописываем структуру данных через конструктор
* добавляем геттеры для возвращения значения параметров
* метод получения из типа/списка тип транспорта
*/
public abstract class Transport {
    //создаем наследуемые параметры (их унаследуют др классы) protected и неизменяемые final
    protected final String vin;
    protected final ZonedDateTime createDate;
    protected final Integer maxSpeed;
    protected final Integer width;
    protected final Integer height;
    protected final Integer length;

    //конструктор.
    //Добавляем через Generate...
    public Transport(String vin, Integer maxSpeed, Integer width, Integer height, Integer length) {
        //параметр vin обязателен для заполнения
        if (vin == null) {
            //эксепшн, выдаем ошибку
            throw new IllegalArgumentException("VIN не может быть null");
        }

        this.vin = vin;
        this.createDate = ZonedDateTime.now(); //вычисляем и передаем текущее время
        this.maxSpeed = maxSpeed;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    //блок геттеров Getters, для возвращения значений параметров.
    //Добавляем через Generate...
    public String getVin() {
        return vin;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getLength() {
        return length;
    }

    public abstract TransportType getType();
}
