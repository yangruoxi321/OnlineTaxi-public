package datatoobject;

import com.ruoxi.constant.ConstantResult;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private int code;
    private String message;
    private T payload;
    public static <T> ResponseResult<T> success(T payload){
        return new ResponseResult<T>()
                .setCode(ConstantResult.SUCCESS.getCode())
                .setMessage(ConstantResult.SUCCESS.getMessage())
                .setPayload(payload);
    }
    public static <T> ResponseResult<T> success(){
        return new ResponseResult<T>()
                .setCode(ConstantResult.SUCCESS.getCode())
                .setMessage(ConstantResult.SUCCESS.getMessage());
    }
    public static <T> ResponseResult<T> fail(){
        return new ResponseResult<T>().setCode(ConstantResult.FAIL.getCode()).setMessage(ConstantResult.FAIL.getMessage());
    }
    public static <T> ResponseResult<T> fail(int code,String message){
        return new ResponseResult<T>().setCode(code).setMessage(message);
    }
}
