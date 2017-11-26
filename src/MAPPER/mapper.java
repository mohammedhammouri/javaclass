package MAPPER;

public interface mapper <From ,To> {

    To map(From from);
    From mapTo(To t);
}
