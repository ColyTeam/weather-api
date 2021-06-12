package dev.coly.weather;

/**
 * Created by Gregyyy on 27.03.2018.
 */
public class UVIndex{

    private Long date;
    private Float value;

    public UVIndex(){
    }

    public UVIndex(Long date, Float value){
        this.date = date;
        this.value = value;
    }

    public Long getDate(){
        return date;
    }

    public void setDate(Long date){
        this.date = date;
    }

    public Float getValue(){
        return value;
    }

    public void setValue(Float value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "UVIndex{" +
                "date=" + date +
                ", value=" + value +
                '}';
    }
}
