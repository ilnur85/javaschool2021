package builder;

import model.Car;

/* ------- ШАГ 5 -------
 * расширяет TransportBuilder и показываем каним классом/дженериком ограничивается Car-ом
 * создаем объект
 * для реализации build возвращаемый тип будет Car
 */
public class CarBuilder extends TransportBuilder<Car> {
    @Override
    public Car build() {
        return new Car(this.vin, this.maxSpeed, this.width, this.height, this.length);
    }
}
