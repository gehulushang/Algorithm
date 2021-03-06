package captcha;

import java.io.OutputStream;
import java.io.Serializable;

public interface ICaptcha extends Serializable {


    void createCode();

    String getCode();

    boolean verify(String userInputCode);

    void write(OutputStream out);


}
