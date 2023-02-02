//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.resultDataFiduciadto;
//import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.getFiduciaGateway;
//import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.getTokenGateway;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.motif_LogRepo;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.getFiduciaServices;
//import id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl.motifLogServiceImpl;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class getFiduciaServiceTest {
//
//    @Autowired
//    private getFiduciaServices getFiduciaServices;
//
//    @MockBean
//    private motif_LogRepo motifLogRepo;
//
//    @MockBean
//    private getFiduciaGateway gateway;
//
//    @MockBean
//    private getTokenGateway getTokenGateway;
//
//    @MockBean
//    private motifLogServiceImpl motifLog;
//
//
//    @Test
//    public void getFiducia_ContractNoIsEmpty() throws Exception {
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = "";
//        String requestBy = "Mobile FMUI";
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("400");
//        responseFiduciaObj.setRespHttpMessage("Contract No can't be null!");
//        responseFiduciaObj.setData(null);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseFiduciaObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void getFiducia_RequestByIsEmpty() throws Exception {
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","101001076621");
//        object.put("requestBy","");
//
//        String contractNo = "101001076621";
//        String requestBy = "";
//
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("400");
//        responseFiduciaObj.setRespHttpMessage("Request By can't be null!");
//        responseFiduciaObj.setData(null);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseFiduciaObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void getFiducia_ApplNoNotFound() throws Exception {
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","101001076621");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = "1010010766211";
//        String requestBy = "Mobile FMUI";
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("404");
//        responseFiduciaObj.setRespHttpMessage("Appl No Not Found!");
//        responseFiduciaObj.setData(null);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//        System.out.println(contractNo);
//        System.out.println(object.get("contractNo"));
//        assertNotNull(resp);
//        assertNotEquals(contractNo, object.get("contractNo"));
//    }
//
//    @Test
//    public void getFiducia_ApplNoFound() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","101001076621");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = "101001076621";
//        String requestBy = "Mobile FMUI";
//
//        List<resultDataFiduciadto> list = new ArrayList<>();
//        resultDataFiduciadto bu = new resultDataFiduciadto();
//        bu.setIdFiducia("e7226e46-6035-4e21-8253-30e372872462");
//        bu.setMime("application/pdf");
//        list.add(bu);
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Sucessfully");
//        responseFiduciaObj.setData(list);
//
//        String applNo = "10121022689";
//        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPZjlLVVNVbEFadFFlMnRqTGJMMFZQVTVYdFcyVmNBc1N3QktxSzIwQkFRIn0.eyJqdGkiOiIwMDAwMWRlNC1lM2UwLTQ5N2EtYTU1Mi1kNmJiYzgxZjg4OTciLCJleHAiOjE2NjEyNDAxMTIsIm5iZiI6MCwiaWF0IjoxNjYxMjM4MzEyLCJpc3MiOiJodHRwOi8vdGVzdGF1dGh0b2tlbi5maWZncm91cC5jby5pZDo4MzgwL2F1dGgvcmVhbG1zL2ZpZmdyb3VwIiwiYXVkIjoiZmlmZ3JvdXAtdG9rZW4iLCJzdWIiOiI5N2ZjZTdlZC1hOGM2LTQxMWMtOWJiNC0wNmJhNGE3MzBjODgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJmaWZncm91cC10b2tlbiIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjIxMjg4MDlkLTI4NDEtNDk3ZS05YTAzLWI2OWQ0ZjU2MmMyOSIsImFjciI6IjEiLCJjbGllbnRfc2Vzc2lvbiI6ImUzNTU0NTIwLTY5YTUtNGM3ZS1iNDBlLThmM2Q4Y2RiZWY5OSIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJtZW1iZXJyZXN0LWFwaS1yb2xlIiwiZmlmZ3JvdXByZXN0LWFwaS1yb2xlIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IiIsInByZWZlcnJlZF91c2VybmFtZSI6InJlcG8ifQ.co_5xpFIrNswadQb5PUmopx9K4qxUBF1FJ4Mw8rCyR5kzdNcefqIgfUKKZYLadZN8_J1oVs6i1ijgI6-sdTkAt0tpKF92KzhZ623IxeOCZQ2gkgjOycorFGB1IJzIy00S54h3UQ7yt8g6ddVY0JLQvQ2-F22IJ0ZRHiMYN4SQAq_cGUPbBZGyYfnmdAxuvyAnE0ms26FZUOowAXiO0CL8xc1Q51zzaxXFGcyzdxXDYrb5kwXf9tAGNeKbwavcfDeacwzKBDQHyTDBBxNQQxXGruNdXylYYq6g4Z2VUEBQdCUVtas4AQR57HS2Ru9ozqdgZaIA5BWEh0LU8gyJMx0Ew";
//        String dataJson = "{\"reqId\":\"1\",\"respCode\":\"00\",\"respMsg\":\"Successful\",\"addRespMsg\":\"\",\"data\":[{\"record\":{\"id\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"custNo\":\"101210020125\",\"nik\":null,\"contractNo\":\"101001076621\",\"applNo\":\"10121022689\",\"preOrderNo\":null,\"leadId\":null,\"source\":\"FIMS\",\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:30:02+0700\",\"custName\":\"HADI RIFANDI\",\"businessUnit\":\"NMC\",\"contractDt\":\"2021-03-08T00:00:00+0700\",\"phase\":\"NORMAL\",\"otp1\":null,\"otp2\":null},\"files\":[{\"id\":\"cf8dea0c-d7e8-4081-8fa0-f3ff39de0a07\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101000000121-R-cert.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J10\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-28T13:57:25+0700\",\"requestId\":\"b093f1e4-31e6-4c5c-85f4-2768b8224cac\"},{\"id\":\"5aa79650-a53a-4d7a-becf-d320436be5e3\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101001076621-F-deed (2).pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J1\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-28T14:10:40+0700\",\"requestId\":\"ca140768-d4e2-4f26-a97a-30181a59a917\"},{\"id\":\"560d76ac-6fac-4cb2-ba26-dc8bd129598d\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"8cb8ac47-63cd-4224-966a-f7d6333271f2.jpeg\",\"mime\":\"image/jpeg\",\"groupDesc\":\"OBJECT\",\"category\":\"DO15\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:36:39+0700\",\"requestId\":\"d90926f2-b0e6-47ec-8ae6-958161e75da5\"},{\"id\":\"7422de7c-41b6-4431-b249-4efbc74b02f1\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"datasheet-hpe_msa_2050.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J4\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-22T11:14:05+0700\",\"requestId\":\"03c41d9e-7411-44d7-b861-808c89ab4cef\"},{\"id\":\"a4449cd8-93fa-46a1-bf71-eecd394b9383\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101001076621-F-deed (3).pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J3\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-28T14:10:32+0700\",\"requestId\":\"1d86b7cb-1c8e-460e-aeec-d5016ac92ab7\"},{\"id\":\"8cb8ac47-63cd-4224-966a-f7d6333271f2\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"Lapangan-Simpang-Lima-Semarang.jpeg\",\"mime\":\"image/jpeg\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC3\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:30:31+0700\",\"requestId\":\"3c562fcb-1d5e-4efd-be36-b94426497043\"},{\"id\":\"e3281464-3bf5-4fb0-9095-a4a5ece0b2a5\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"0165d1eb-fbf3-415e-9b36-2770ba49dad8.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC4\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:33:55+0700\",\"requestId\":\"9d5498a4-aa86-48bd-bb25-ef0fd8009230\"},{\"id\":\"3fc0c577-8405-48ac-a7bb-9d90f59a4b89\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101000002721-R.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC10\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:40:18+0700\",\"requestId\":\"bd7d3a77-d27a-4071-98e8-a5ad4d8813f0\"},{\"id\":\"8a1e6575-b4cd-42e6-8cd0-515d08832ca1\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"application_octet-stream_byte_repositoryId=0165d1eb-fbf3-415e-9b36-2770ba49dad8_blob_http___localhost_8282_7e68b98f-2382-4663-8060-829e209816ba.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC1\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-15T09:24:52+0700\",\"requestId\":\"5de087ac-9ba3-4209-9ea3-5cc96e2f732f\"},{\"id\":\"a4ae9355-ecbb-49e7-bb41-a9438cc28275\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"3.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"OBJECT\",\"category\":\"DO1\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-13T10:45:41+0700\",\"requestId\":\"d93c240b-f0f0-466b-a095-53a252538c65\"},{\"id\":\"9b095bc1-ae3b-406f-979f-ebfbd039e508\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"3.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"OTHERS\",\"category\":\"J6\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-22T11:13:56+0700\",\"requestId\":\"25c9831d-a902-41c5-be00-df1d39352e4a\"},{\"id\":\"e97f2369-caa6-4f70-ac62-253b5cc17b4a\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"2_2.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"OTHERS\",\"category\":\"J5\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-22T11:14:09+0700\",\"requestId\":\"92c13b9b-92a8-4276-bd56-be63a8a0d5d6\"},{\"id\":\"e38d835c-3ffe-4008-b36d-0893bcb0aeba\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101000002721-R.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J20\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-15T16:02:57+0700\",\"requestId\":\"db0cc2b7-ee54-4fd4-910c-8593093d2a5c\"},{\"id\":\"a2051770-b74b-45d7-a7f0-fe7b7891df95\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101000002721-R.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J22\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-15T16:03:00+0700\",\"requestId\":\"a6311afe-5829-4574-8966-70bc511fcad3\"},{\"id\":\"257e85e4-4cec-42bf-b56e-56950a42698f\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101000002721-R.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J2\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-15T15:53:26+0700\",\"requestId\":\"bb4af4c2-daf7-49db-a26b-c93266e02b5f\"},{\"id\":\"e7226e46-6035-4e21-8253-30e372872462\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"101001076621-F.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J18\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2021-12-15T16:02:54+0700\",\"requestId\":\"8aef5073-0a3f-418c-8b9a-6f4198720e38\"},{\"id\":\"394230a4-c54f-46e2-890b-b015339fa2f4\",\"recordId\":\"246083c2-9ebd-4520-a54e-de811e4739a8\",\"name\":\"1 SAMIYEM 2021121615300049_Sertifikat_Roya.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J33\",\"source\":\"FIMS\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"cabang\",\"submitDt\":\"2022-03-24T10:08:10+0700\",\"requestId\":\"456a8b70-2e86-40de-a55e-f1b93ca407e4\"}]}]}\n";
//
//        when(motifLogRepo.queryStr(contractNo)).thenReturn(applNo);
//        when(getTokenGateway.getToken()).thenReturn(token);
//        when(gateway.getId(applNo, requestBy, token)).thenReturn(dataJson);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//        System.out.println(contractNo);
//        System.out.println(object.get("contractNo"));
//        assertNotNull(resp);
//        assertEquals(contractNo, object.get("contractNo"));
//    }
//
//    @Test
//    public void getFiducia_IdFileFiduciaNotFound() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","1041900000323");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = "1041900000323";
//        String requestBy = "Mobile FMUI";
//
//        List<resultDataFiduciadto> list = new ArrayList<>();
//        resultDataFiduciadto bu = new resultDataFiduciadto();
//        bu.setIdFiducia(null);
//        bu.setMime(null);
//        list.add(bu);
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("404");
//        responseFiduciaObj.setRespHttpMessage("Id File Fiducia Not Found in Repo!");
//        responseFiduciaObj.setData(list);
//
//        String applNo = "10419000323";
//        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPZjlLVVNVbEFadFFlMnRqTGJMMFZQVTVYdFcyVmNBc1N3QktxSzIwQkFRIn0.eyJqdGkiOiJkYTUzYTM1NC05YTJkLTQ1NGYtYWYxNi02ODU4NzY1NWQ0NjgiLCJleHAiOjE2NjEyNDI5MDYsIm5iZiI6MCwiaWF0IjoxNjYxMjQxMTA2LCJpc3MiOiJodHRwOi8vdGVzdGF1dGh0b2tlbi5maWZncm91cC5jby5pZDo4MzgwL2F1dGgvcmVhbG1zL2ZpZmdyb3VwIiwiYXVkIjoiZmlmZ3JvdXAtdG9rZW4iLCJzdWIiOiI5N2ZjZTdlZC1hOGM2LTQxMWMtOWJiNC0wNmJhNGE3MzBjODgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJmaWZncm91cC10b2tlbiIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjJlZmZlYTg5LTA2MmUtNGI0My1hNmQ2LTY4Y2IzMWFiNWFhZCIsImFjciI6IjEiLCJjbGllbnRfc2Vzc2lvbiI6ImZlODI0Y2VhLWUxZDMtNGYxZC1iMDgyLTc2NmZjZjdjZjFhZiIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJtZW1iZXJyZXN0LWFwaS1yb2xlIiwiZmlmZ3JvdXByZXN0LWFwaS1yb2xlIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IiIsInByZWZlcnJlZF91c2VybmFtZSI6InJlcG8ifQ.irUg9S8eg6AgESe3BanLbperXNv-Vc32lFDgi8ysRyfqvvsv7NC4Kn21MY7PHbGZhzO3VU2LlenZBvMGFzlNO2epvP6AqR9Ic5OKqQys_RBw8ZsBOXFeAm_LrSEp_zdkKbBN7yet0kvZTqp1Ry7Ik5B9rnrFK0y2ArsEYPJ731XaIBcJTlY6VeJTaETIkJyjJNRPhXp5vmhUZ3MPozL-mCIXvMO7Cp4XqDTNcK0Nn1hOh1mW6Xh_1BBQF50cAjCIfNqKSOke-f4DN1oZUQmrQFz5tLAUeshkrI9vWT6-DxwdPtLV6SkumAoD2sRLu-7faP8G50ITmeLfnhNdXKCmAg";
//        String dataJson = "{\"reqId\":\"1\",\"respCode\":\"00\",\"respMsg\":\"Successful\",\"addRespMsg\":\"\",\"data\":[{\"record\":{\"id\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"custNo\":\"130160023988\",\"nik\":\"1701080411870001\",\"contractNo\":\"104000210319\",\"applNo\":\"10419000323\",\"preOrderNo\":null,\"leadId\":null,\"source\":\"F\",\"submitBy\":\"10017\",\"submitDt\":\"2019-10-01T13:57:10+0700\",\"custName\":\"DADANG ISMANAP\",\"businessUnit\":\"REFI\",\"contractDt\":\"2019-02-19T13:04:42+0700\",\"phase\":\"NORMAL\",\"otp1\":null,\"otp2\":null},\"files\":[{\"id\":\"f23375ac-7f53-4995-bb2c-89eefd28c3c9\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"Surat Kuasa.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC1\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2022-02-21T21:53:14+0700\",\"requestId\":\"67dbe85f-5ff1-4384-8c2f-9c3d51fd0492\"},{\"id\":\"60723d60-0b8b-496b-95e0-83e8bdf0e9dd\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"10017104190003231569912944601.C4F32_1_003.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC2\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2019-10-01T13:57:11+0700\",\"requestId\":\"80bf383d-ee4b-451a-8beb-f9b6389efd32\"},{\"id\":\"c0a88058-7e4f-46a7-a74f-281ec2201026\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"10017104190003231569912944601.C13F32_1_002.jpg\",\"mime\":\"image/jpg\",\"groupDesc\":\"CUSTOMER\",\"category\":\"DC3\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2019-10-01T13:57:12+0700\",\"requestId\":\"d79e2226-d94d-4ed3-8659-d632660a8157\"},{\"id\":\"0c5106f9-0aee-439b-b877-24bab8016657\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j1.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J1\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"78da3dea-aa0d-4768-ad47-26f4559d850f\"},{\"id\":\"c9eb529a-36ff-489d-94c5-2333d52fd800\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j30.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J30\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"ae78ce4a-2fe9-42d5-b63b-6d8e21c9a462\"},{\"id\":\"c1aef5e4-3e6e-45b7-a66b-2e1aed59cb4b\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j32.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J32\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"c20a7fa6-c9c3-4ebe-8eb8-84a9ae167e91\"},{\"id\":\"66039f9c-2bbc-4671-b570-63fd6891da74\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j33.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J33\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"db63160a-af99-4b50-a578-bf951f384dc8\"},{\"id\":\"400f7294-aaae-462e-9431-27a35b4e60ad\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j35.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J35\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"c560eec0-1535-4e71-8237-181b11992e0c\"},{\"id\":\"6867db8a-3ce0-4aeb-9744-8697b4b65c84\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000006219j34.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J34\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-06-02T14:12:26+0700\",\"requestId\":\"d282365c-a02d-4a97-bd00-3281ebd1dcb7\"},{\"id\":\"e3232a31-2285-47da-b46b-461d81999dbd\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000006219j2.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J2\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-06-02T14:12:27+0700\",\"requestId\":\"bcc118cf-9a40-4a82-98a2-235ff699bd21\"},{\"id\":\"c647f9c7-1588-47c9-ae05-5a2020a18cad\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000006219j3.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J3\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-06-02T14:12:27+0700\",\"requestId\":\"222add06-741a-4e1f-b981-8c36429bc871\"},{\"id\":\"3e513438-ea90-4b24-9d51-5f2e4951bc2e\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000006219j9.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J9\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-06-02T14:12:27+0700\",\"requestId\":\"b18a77a4-d940-4646-835f-f5c166556c1a\"},{\"id\":\"2bb2fd3c-589d-49d2-af9a-41205983b3fa\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j31.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J31\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"157513fb-812c-4efd-b015-94760194cafc\"},{\"id\":\"d9d44a21-8f24-4cb6-901e-1a111d1c0943\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000210319j29.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J29\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-03-03T14:12:44+0700\",\"requestId\":\"6cb58ce9-b265-4bb6-9f84-347f2830e73b\"},{\"id\":\"2311a2e1-82e3-418a-96ce-88bcf709a7a6\",\"recordId\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"name\":\"104000006219j28.pdf\",\"mime\":\"application/pdf\",\"groupDesc\":\"OTHERS\",\"category\":\"J28\",\"source\":\"F\",\"tag1\":null,\"tag2\":null,\"tag3\":null,\"tag4\":null,\"tag5\":null,\"submitBy\":\"10017\",\"submitDt\":\"2020-06-02T14:12:26+0700\",\"requestId\":\"5f94cabb-62f2-4f68-a898-0f685ff5a600\"}]}]}";
//
//        when(motifLogRepo.queryStr(contractNo)).thenReturn(applNo);
//        when(getTokenGateway.getToken()).thenReturn(token);
//        when(gateway.getId(applNo, requestBy, token)).thenReturn(dataJson);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//        //verify mock is call
//        verify(motifLogRepo).queryStr(contractNo);
//        verify(getTokenGateway).getToken();
//        verify(gateway).getId(applNo, requestBy, token);
//
//        System.out.println(contractNo);
//        System.out.println(object.get("contractNo"));
//
//        assertNotNull(resp);
//        assertEquals(contractNo, object.get("contractNo"));
//    }
//
//    @Test
//    public void getFiducia_ApplNoNotFoundInRepo() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("contractNo","1041900000323");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = "1041900000323";
//        String requestBy = "Mobile FMUI";
//
//        List<resultDataFiduciadto> list = new ArrayList<>();
//        resultDataFiduciadto bu = new resultDataFiduciadto();
//        bu.setIdFiducia(null);
//        bu.setMime(null);
//        list.add(bu);
//
//        //Data out ext api
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("404");
//        responseFiduciaObj.setRespHttpMessage("Appl No Not Found in Repo!");
//        responseFiduciaObj.setData(list);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String applNo = "";
//        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPZjlLVVNVbEFadFFlMnRqTGJMMFZQVTVYdFcyVmNBc1N3QktxSzIwQkFRIn0.eyJqdGkiOiJkYTUzYTM1NC05YTJkLTQ1NGYtYWYxNi02ODU4NzY1NWQ0NjgiLCJleHAiOjE2NjEyNDI5MDYsIm5iZiI6MCwiaWF0IjoxNjYxMjQxMTA2LCJpc3MiOiJodHRwOi8vdGVzdGF1dGh0b2tlbi5maWZncm91cC5jby5pZDo4MzgwL2F1dGgvcmVhbG1zL2ZpZmdyb3VwIiwiYXVkIjoiZmlmZ3JvdXAtdG9rZW4iLCJzdWIiOiI5N2ZjZTdlZC1hOGM2LTQxMWMtOWJiNC0wNmJhNGE3MzBjODgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJmaWZncm91cC10b2tlbiIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjJlZmZlYTg5LTA2MmUtNGI0My1hNmQ2LTY4Y2IzMWFiNWFhZCIsImFjciI6IjEiLCJjbGllbnRfc2Vzc2lvbiI6ImZlODI0Y2VhLWUxZDMtNGYxZC1iMDgyLTc2NmZjZjdjZjFhZiIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJtZW1iZXJyZXN0LWFwaS1yb2xlIiwiZmlmZ3JvdXByZXN0LWFwaS1yb2xlIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IiIsInByZWZlcnJlZF91c2VybmFtZSI6InJlcG8ifQ.irUg9S8eg6AgESe3BanLbperXNv-Vc32lFDgi8ysRyfqvvsv7NC4Kn21MY7PHbGZhzO3VU2LlenZBvMGFzlNO2epvP6AqR9Ic5OKqQys_RBw8ZsBOXFeAm_LrSEp_zdkKbBN7yet0kvZTqp1Ry7Ik5B9rnrFK0y2ArsEYPJ731XaIBcJTlY6VeJTaETIkJyjJNRPhXp5vmhUZ3MPozL-mCIXvMO7Cp4XqDTNcK0Nn1hOh1mW6Xh_1BBQF50cAjCIfNqKSOke-f4DN1oZUQmrQFz5tLAUeshkrI9vWT6-DxwdPtLV6SkumAoD2sRLu-7faP8G50ITmeLfnhNdXKCmAg";
//        String dataJson = "{\"reqId\":\"1\",\"respCode\":\"404\",\"respMsg\":\"Successful\",\"addRespMsg\":\"\",\"data\":[{\"record\":{\"id\":\"80e07af5-9ea0-4175-a782-b5c177270673\",\"custNo\":\"130160023988\",\"nik\":\"1701080411870001\",\"contractNo\":\"104000210319\",\"applNo\":\"10419000323\",\"preOrderNo\":null,\"leadId\":null,\"source\":\"F\",\"submitBy\":\"10017\",\"submitDt\":\"2019-10-01T13:57:10+0700\",\"custName\":\"DADANG ISMANAP\",\"businessUnit\":\"REFI\",\"contractDt\":\"2019-02-19T13:04:42+0700\",\"phase\":\"NORMAL\",\"otp1\":null,\"otp2\":null}}";
//
//        when(motifLogRepo.queryStr(contractNo)).thenReturn(applNo);
//        when(getTokenGateway.getToken()).thenReturn(token);
//        when(gateway.getId(applNo, requestBy, token)).thenReturn(dataJson);
//
//        //Resp data ext api
//        ResponseEntity resp = getFiduciaServices.getfiducia(contractNo, requestBy);
//
//        //verify mock is call
//        verify(motifLogRepo).queryStr(contractNo);
//        verify(getTokenGateway).getToken();
//        verify(gateway).getId(applNo, requestBy, token);
//
//        System.out.println(contractNo);
//        System.out.println(object.get("contractNo"));
//
//        assertNotNull(resp);
//        assertEquals(contractNo, object.get("contractNo"));
//    }
//
//
//}
//
