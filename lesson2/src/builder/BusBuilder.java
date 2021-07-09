package builder;

import model.Bus;

/* ------- ШАГ 5 -------
 * расширяет TransportBuilder и показываем каним классом/дженериком ограничивается Bus-ом
 * создаем объект
 * для реализации build возвращаемый тип будет Bus
 */
public class BusBuilder extends TransportBuilder<Bus> {
    @Override
    public Bus build() {
        return new Bus(this.vin, this.maxSpeed, this.width, this.height, this.length);
    }
}
