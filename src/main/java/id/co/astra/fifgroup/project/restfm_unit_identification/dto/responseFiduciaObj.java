package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

public class responseFiduciaObj {
    private String respHttpCode;
    private String respHttpMessage;
    private Object data;

    public String getRespHttpCode() {
        return respHttpCode;
    }

    public void setRespHttpCode(String respHttpCode) {
        this.respHttpCode = respHttpCode;
    }

    public String getRespHttpMessage() {
        return respHttpMessage;
    }

    public void setRespHttpMessage(String respHttpMessage) {
        this.respHttpMessage = respHttpMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
