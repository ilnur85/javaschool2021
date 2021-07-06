package model;

/*------- ШАГ 3 -------
 * extends Transport - Moto наследник Transport-а
 * будут красными, надо имплементировать с методом И с конструктором метода
 * т.к. у Transport есть конструктор, то и все его наследники должны реализовывать этот конструктор
 */
public class Moto extends Transport {
    public Moto(String vin, Integer maxSpeed, Integer width, Integer height, Integer length) {
        super(vin, maxSpeed, width, height, length);
    }

    @Override
    public TransportType getType() {
        //Moto должен возвращать MOTO
        return TransportType.MOTO;
    }
}
