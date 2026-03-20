package example.day12.crwaling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

@Service
public class CrawlingService {

    // [1] Jsoup 이용한 특정 url html 정보 수집
    public List<String> test1(){
        List<String> list = new ArrayList<>(); // 여러개 문자열 저장 리스트
        // 1) 크롤링 URL 웹페이지 주소
        for(int page = 1; page <= 10; page++){

        }
        String url = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";
        // 2) 크롤링 할 URL 요청하여 HTML 전체를 가져온다. Jsoup.connect( 주소 ).get();
        // Document import org.jsoup.nodes.Document;
        try {
            Document document = Jsoup.connect( url ).get(); // 외부 통신은 일반예외 주로 발생
            // 3) 특정한 마크업/요소 식별자 , document.select( "식별자" );
            Elements elements = (Elements) document.select( ".lead.line-6x2 a"); // 클래스가 titles인 마크업 아래에 <a> 가져온다.
            System.out.println("elements = " + elements);
            // 4) 여러개 가져 왔다면
            for( Element element : elements ){
                String title = element.text(); // vs innerHTML 비슷하게 마크업 사이 텍스트를 호출
                if( !title.isBlank() ) list.add(title);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    // [2] jsoup 이용한 HTML 정보 수집, 페이지 이동, url 분석이 필요하다.
    public List<Map<String, Object>> test2(){
        List<Map<String, Object>> list = new ArrayList<>(); // 책정보(dto/map)들을 담는 리스트 선언
        try{
            for(int page = 1; page <= 3; page++){ // page는 1부터 3까지
                // 크롤링 URL 주소 ( 예스24 베스트셀러 일별 ) ++ 반복문 이용하여 페이지번호 여러개 요청
                String url = "https://www.yes24.com/product/category/daybestseller";
                url += "?categoryNumber=001"; // 베스트셀러 카테고리 번호
                url += "&pageNumber="+page; // 크롤링할 페이지 번호 < page 변수로 활용 >
                url += "&pageSize=24"; // 페이지당 제품 수
                // 2) URL 연결
                Document document = Jsoup.connect( url ).get();
                // 3) 식별자 , 단일 선택자일 때는 중복 발생 // 주로 복수 선택자로 중복을 최대한 없앤다.
                // 책 이름 info_name .gd_name
                Elements nameList = document.select(".info_name .gd_name");
                // 책 가격 info_price txt_num .yes_b
                Elements priceList = document.select(".info_price .txt_num .yes_b");
                // 책 이미지 img_bdr .lazy
                Elements imageList =  document.select(".img_bdr .lazy");
                // 4) 반복문 이용하여 여러개 요소/마크업들을 도서별 MAP 구성하여 LIST 저장
                for(int index = 0; index < nameList.size(); index++){
                    String name = nameList.get(index).text();
                    String price = priceList.get(index).text();
                    // text() : 마크업 사이 텍스트 반환, attr( 속성명 ) : 해당 속성명의 속성값 바노한
                    String image = imageList.get(index).attr("data-original");
                    // 5) DTO/MAP 구성
                    Map<String, Object> map = new HashMap<>();
                    map.put( "name", name); map.put("price", price); map.put("image", image);
                    // 6)
                    list.add(map);
                }
            }
        }catch (Exception e){ System.out.println(e); }
        return list;
    }

    // [3]
    public Map<String, Object> test3(){
        // 1] 크롬 드라이버 설치
        WebDriverManager.chromedriver().setup();
        // 2] 크롤링 할 웹 주소
        String url = "https://weather.daum.net";
        // 3] 크롬 드라이버 객체 생성
            // * 드라이버 옵션
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new", "--disable-gpu"); // 크롬 백그라운드 실행
        WebDriver webDriver = new ChromeDriver( options );
        // 4] 크롬 드라이버 객체에 크롤링할 주소 넣기
        webDriver.get(url);
        // 5] 해당 페이지는 동적( 데이터를 표현하는데 부분적 시간필요 ) 페이지
            // new WebDriverWait ( 현재크롬객체 , Duration.ofXXX( 대기단위 ) ) --> 사람인척 하기 위함.
        WebDriverWait wait = new WebDriverWait( webDriver , Duration.ofSeconds( 1 ) );
        // 6] 크롤링할 선택자
            // WebElement 변수명 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("선택자")));
            // 6-1) 온도 : info_weather -> num_deg
        WebElement temp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".info_weather .num_deg")));    // 1) 온도 : info_weather -> num_deg
        System.out.println( temp.getText() ); // 크롤링된 요소/마크업의 텍스트 확인
            // 6-2 초미세먼지 : item_air tooltip_icon ico_airstat1
        WebElement temp2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list_air .ico_airstat1")));
        System.out.println( temp2.getText() );
        Map<String, Object> map = new HashMap<>();
        map.put("온도", temp.getText());
        map.put("초미세먼지", temp2.getText());

        // 8] 안전하게 드라이버 객체 직접 종료
        webDriver.quit();
        // 9] map 반환
        return map;
    }

    // [4] CGV 특정 영화 관란평 크롤링 ( +무한 스크롤 )
    public List<String> test4(){
        // [1] 크롬 설치
        WebDriverManager.chromedriver().setup();
        // [2] 웹 크롤링할 url
        String url = "https://cgv.co.kr/cnm/cgvChart/movieChart/30000927";
        // [3] 크롤링할 크롬 드라이버 객체 생성
        ChromeOptions options = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver( options );
        webDriver.get( url ); // [4] 크롬 객체 내 크롤링 url 대입

        try{ Thread.sleep(3000); }catch (Exception e){ } // 1초간 대기

        // *** 자바에서 JS제어하여 스크롤을 내리는 작업 ***
        JavascriptExecutor js = (JavascriptExecutor) webDriver; // (현재) 크롬객체에서 JS객체 꺼내기
        js.executeScript( "window.scrollTo( 500 , document.body.scrollHeight)"); // .executeScript("JS문법");
            // "window.scrollTo( 100 , document.bodt.scrollHeight");
                // document.body.scrollHeight : 현재 화면에서 스크롤 전체 길이 = 높이 = 300px , 상단꼭지점 = 0, 하단꼭지점 = 300
                    // .scrollTo( 이동할 위치, 전체길이 )

        try{ Thread.sleep(1500); }catch (Exception e){ } // 1초간 대기

        // *** 크롤링할 선택자로 요소 크롤링 ***
        List<String> list = new ArrayList<>();
        for(int page = 1; page <= 30; page++){
            int startCount = list.size(); // 현재 리뷰 개수
            // WebElement // 1개 요소
            List<WebElement> elements = webDriver.findElements( By.cssSelector(" .cnms01020_reviewList__UuNuN .reveiwCard_txt__RrTgu ")); // 여러개 요소
            System.out.println( "elements = " + elements ); //확인용
            for(WebElement element : elements){
                System.out.println( element ); // 확인용
                if( !list.contains( element.getText() ) ){
                    list.add( element.getText() );
                }
            }
            int endCount = list.size(); // 특정 반복문 1회 종료 후
            if( startCount == endCount ) break;

            // *** 스크롤 내리기 작업 **
            js.executeScript( "window.scrollTo( 200 , document.body.scrollHeight ); "); // .executeScript("JS문법");
            try{ Thread.sleep(1000); }catch (Exception e){ } // 1초간 대기
        }

        webDriver.quit();
        // [6] 크롤링 선택자
        // .cnms01020_reviewList__UuNuN .reveiwCard_txt__RrTgu

        return list;
    }
}
/*
        - 웹 크롤링 : 웹(페이지의) HTML 정보/자료 수집 과정
        - 웹페이지 마다 크롤링 허용 여부 : URL/robots.txt
            - https://www.jobkorea.co.kr/robots.txt
        - 정적페이지 : HTML   , 동적페이지 : JS ( AXIOS/REACT )
            - 정적페이지 : Jsoup 라이브러리
            - 동적페이지 : Selenium 라이브러리 ( *파이썬 동일 * )
        - Jsoup 라이브러리 : implementation 'org.jsoup:jsoup:1.21.2'
        - Selenium 라이브러리 :
     */
