package applications.components.tables.currencyTables;

import arithmetic.Pfloat;
import arithmetic.PfloatCurrency;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import platforms.currencies.Currency;

public class CurrencyData {
	protected final Currency currency;

	protected final IntegerProperty rank;
	protected final StringProperty name;
	protected final ObjectProperty<Pfloat> price;
	protected final ObjectProperty<Pfloat> marketCap;
	protected final ObjectProperty<Pfloat> volume;

	public CurrencyData(Currency currency, int rank, String name, Pfloat price, Pfloat marketCap, Pfloat volume) {
		this.currency = currency;

		this.rank = new SimpleIntegerProperty(rank);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleObjectProperty<>(new PfloatCurrency(price));
		this.marketCap = new SimpleObjectProperty<>(new PfloatCurrency(marketCap));
		this.volume = new SimpleObjectProperty<>(new PfloatCurrency(volume));
	}

	public Currency getCurrency() {
		return currency;
	}

	public IntegerProperty rankProperty() {
		return rank;
	}

	public StringProperty nameProperty() {
		return name;
	}

	public ObjectProperty<Pfloat> priceProperty() {
		return price;
	}

	public ObjectProperty<Pfloat> marketCapProperty() {
		return marketCap;
	}

	public ObjectProperty<Pfloat> volumeProperty() {
		return volume;
	}
}
