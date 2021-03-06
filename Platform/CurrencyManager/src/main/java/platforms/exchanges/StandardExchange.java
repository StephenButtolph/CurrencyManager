package platforms.exchanges;

import java.util.ArrayList;
import java.util.Collection;

import arithmetic.Pfloat;
import platforms.currencies.markets.CurrencyMarket;
import platforms.exchanges.markets.CurrencyExchange;
import platforms.exchanges.markets.StandardCurrencyExchange;
import platforms.offers.offerGroups.Offers;
import utils.collections.iterables.IterableUtils;

/**
 * The implementation of standard functions for exchanges.
 * 
 * @author Stephen Buttolph
 */
public abstract class StandardExchange implements Exchange {
	protected abstract Offers getRawOffers(CurrencyMarket exchangePair);

	protected abstract Offers adjustOffers(Offers rawOffers);

	protected abstract Collection<? extends CurrencyMarket> getOriginalCurrencyMarkets();

	protected boolean shouldInvert(CurrencyMarket market) {
		return !getOriginalCurrencyMarkets().contains(market);
	}

	public CurrencyExchange getCurrencyExchange(CurrencyMarket market) {
		return new StandardCurrencyExchange(this, market);
	}

	@Override
	public Offers getOffers(CurrencyMarket market) {
		Offers rawOffers = getRawOffers(market);
		return adjustOffers(rawOffers);
	}

	@Override
	public Collection<CurrencyMarket> getCurrencyMarkets() {
		Collection<? extends CurrencyMarket> originalMarkets = getOriginalCurrencyMarkets();

		Collection<CurrencyMarket> markets = new ArrayList<>(originalMarkets);
		Iterable<? extends CurrencyMarket> invertedMarkets = IterableUtils.map(originalMarkets, CurrencyMarket::invert);
		invertedMarkets.forEach(markets::add);

		return markets;
	}

	@Override
	public Pfloat getPrice(CurrencyMarket market) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pfloat getPrice(CurrencyMarket market, Pfloat amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pfloat getReturn(CurrencyMarket market, Pfloat amount) {
		// TODO Auto-generated method stub
		return null;
	}
}
