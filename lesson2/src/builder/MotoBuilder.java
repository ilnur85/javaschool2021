package builder;

import model.Moto;

/* ------- ШАГ 5 -------
 * расширяет TransportBuilder и показываем каним классом/дженериком ограничивается Moto-ом
 * создаем объект
 * для реализации build возвращаемый тип будет Moto
 */
public class MotoBuilder extends TransportBuilder<Moto> {
    @Override
    public Moto build() {
        return new Moto(this.vin, this.maxSpeed, this.width, this.height, this.length);
    }
}
