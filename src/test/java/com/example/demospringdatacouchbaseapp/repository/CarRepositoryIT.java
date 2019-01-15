package com.example.demospringdatacouchbaseapp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demospringdatacouchbaseapp.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryIT {

  @Autowired
  private CarRepository repository;

  // @Before
  // public void clearDatabase() {
  // repository.deleteAll();
  // }

  @Test
  public void createSingCarTest() {

    /*
     * Given
     */

    Car givenCar = createMadWeeClio();

    /*
     * When
     */

    Car persistedCar = repository.save(givenCar);

    /*
     * Then
     */

    assertThat(persistedCar).isEqualTo(givenCar.withId(getExpectedId(givenCar)));

  }

  @Test
  @Ignore("entities are not coming back with generated ID's. Wither not working?")
  public void createCollectionOfCarsTest() {

    /*
     * Given
     */

    Collection<Car> givenCars = Arrays.asList(createMadWeeClio(), createMadMeg());
    Collection<Car> expectedPersistedCars =
        Arrays.asList(withExpectedId(createMadWeeClio()), withExpectedId(createMadMeg()));

    /*
     * When
     */

    Iterable<Car> persistedCars = repository.saveAll(givenCars);

    /*
     * Then
     */

    assertThat(persistedCars)
        .as("given we started with an empty database, it should only contain the cars we just "
            + "inserted")
        .containsOnlyElementsOf(expectedPersistedCars);

  }

  @Test
  public void findByIdTest() {

    /*
     * Given
     */

    Car givenCar = createMadWeeClio();
    String expectedId = getExpectedId(givenCar);

    repository.save(givenCar);

    /*
     * When
     */

    Optional<Car> result = repository.findById(expectedId);

    /*
     * Then
     */

    assertThat(result.get())
        .as("the car we inserted should be searchable by the id that should be generated for it")
        .isEqualTo(givenCar.withId(expectedId));

  }

  @Test
  @Ignore("fails due to missing all view")
  public void findAllTest() {

    /*
     * Given
     */

    Collection<Car> givenCars = Arrays.asList(createMadWeeClio(), createMadMeg());

    repository.saveAll(givenCars);

    /*
     * When
     */

    Iterable<Car> result = repository.findAll();

    /*
     * Then
     */

    assertThat(result).as("we inserted a number of cars into an empty database, "
        + "therefore that number of cars should be in the database").hasSameSizeAs(givenCars);

  }

  @Test
  @Ignore("fails due to missing all view")
  public void deleteAllTest() {

    /*
     * Given
     */

    repository.saveAll(Arrays.asList(createMadWeeClio(), createMadMeg()));

    /*
     * When
     */

    repository.deleteAll();

    /*
     * Then
     */

    assertThat(repository.findAll()).isEmpty();

  }

  @Test
  // @Ignore
  public void deleteSingleCarTest() {

    /*
     * Given
     */

    Car madWeeClio = createMadWeeClio();
    Car madMeg = createMadMeg();

    repository.saveAll(Arrays.asList(madWeeClio, madMeg));

    String madWeeClioId = getExpectedId(madWeeClio);
    String madMegId = getExpectedId(madMeg);

    /*
     * When
     */

    repository.deleteById(madWeeClioId);

    /*
     * Then
     */

    assertThat(repository.existsById(madMegId))
        .as(String.format("we never deleted %s so it should still exist", madMegId)).isTrue();

    assertThat(repository.existsById(madWeeClioId))
        .as(String.format("we deleted %s so it should not still exist", madWeeClioId)).isFalse();

  }

  private String getExpectedId(Car givenCar) {
    return givenCar.getManufacturer() + Car.ID_DELIMITER + givenCar.getModel() + Car.ID_DELIMITER
        + givenCar.getSpec();
  }

  private Car withExpectedId(Car car) {
    return car.withId(getExpectedId(car));
  }

  private Car createMadWeeClio() {
    return Car.builder().manufacturer("RenaultSport").model("Clio").spec("200 Cup").colour("white")
        .build();
  }

  private Car createMadMeg() {
    return Car.builder().manufacturer("RenaultSport").model("Megane").spec("R.S Trophy")
        .colour("Yellow").build();
  }

}
