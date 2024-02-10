# 입출력 스트림과 파일 입출력

## 8.1 자바의 입출력 스트림

### 스트림 입출력이란?

* 스트림(stream)은 컴퓨터 공학에서 연속적인 데이터의 흐름 혹은 데이터를 전송하는 소프트웨어 모듈을 일컬음
* 컴퓨터에서 스트림은 도착한 순서대로 데이터를 흘려보냄
* JAVA에서 입출력 스트림은 응용프로그램과 입출력 장치를 연결하는 소프트웨어 모듈
* 예를 들어 입력 스트림은 키보드 장치를 제어하여 사용자의 키 입력을 받아 응용프로그램에게 전달하고, 응용프로그램은 출력 스트림에 연결하여 출력 장치를 제어하여 출력을 완성함
* 스트림 입출력 방식에서 JAVA 응용프로그램은 입출력 장치를 직접 제어하는 대신, 입출력 스트림 객체와 연결하여 쉽게 데이터 입출력을 실행함
* 스트림을 사용하지 않고 입출력 장치를 직접 제어하는 코드를 작성하여 입출력을 실행하려고 한다면, 응용프로그램 작성이 매우 어렵고, 하드웨어 구조가 다양한 입출력 장치를 모두 수용할 수 없게 될 것

#### ● 스트림의 양끝에는 입출력 장치와 JAVA 으용프로그램이 연결됨

* JAVA 응용프로그램은 입력 스트림과 출력 스트림과만 연결하고, 입출력 스트림이 입출력 장치를 제어하고 실질적인 입출력을 담당함

#### ● 스트림은 단방향임

* 입력 스트림은 입력 장치에서 응용프로그램으로 데이터를 전송하며, 출력 스트림은 응용프로그램으로부터 받은 데이터를 출력 장치로 전송함
* 두 가지 기능을 모두 가진 스트림은 없음

#### ● 스트림을 통해 흘러들어가는 기본 단위는 바이트나 문자임

* JAVA의 스트림 객체는 바이트를 단위로 입출력하는 바이트 스트림과 문자 단위로 입출력하는 문자 스트림으로 나뉨

#### ● 스트림은 선입선출, 즉 FIFO 구조임

* 입력 스트림에 먼저 들어온 데이터가 응용프로그램에 먼저 전달되고, 출력 스트림은 응용프로그램이 출력한 순서대로 출력 장치에 보냄

### 바이트 스트림과 문자 스트림

* JAVA에서 입출력 스트림은 문자 스트림(character stream)과 바이트 스트림(byte stream)의 2종류로 나눔
* 문자 스트림은 문자만 다루기 때문에, 문자가 아닌 데이터가 출력되면 보이지 않거나 엉뚱한 기호가 출력되며, 문자가 아닌 정보가 입력되면 응용프로그램에게 엉뚱한 문자가 전달되는 오류가 발생함
* JAVA에서 char타입, 즉 문자 하나의 크기는 2바이트임
* 한편, 바이트 스트림은 바이트를 단위로 다루는 스트림으로, 스트림에 들어오고 나가는 정보를 단순 바이너리(비트들)로 다루기 때문에, 문자이든 이미지 바이트든 상관없이 흘려보냄
* java.io 패키지에는 다양한 스트림 클래스가 포함됨
* 바이트 스트림을 다루는 클래스는 공통적으로 이름 뒤에 Stream을 붙이고, 문자 스트림을 다루는 클래스는 Reader/Writer를 붙여 구분함
* 텍스트 파일 등 문자들로만 이루어진 파일과는 달리, 이미지나 오디오/비디오 파일의 데이터는 문자가 아닌 바이너리 정보들이므로, 이들을 읽고 쓰는 경우 반드시 바이트 스트림 클래스를 사용해야 함

### 스트림 연결

* 스트림은 서로 연결될 수 있음
* JAVA 응용프로그램에서 바이트 스트림과 문자 스트림을 연결하는 예시는 다음과 같음

    ```JAVA
    InputStreamReader rd = new InputStreamReader(System.in);
    ```

* 문자 스트림 rd를 생성하고, 키보드와 연결된 표준 입력 스트림은 System.in을 연결함
* System.in은 InputStream 타입으로 바이트 입력 스트림임
* 두 스트림이 연결되면, System.in은 사용자의 키 입력을 받아 바이트 스트림으로 내보내며, rd는 들어오는 바이트 스트림을 문자로 구성하여 응용프로그램에게 전달함
* JAVA 응용프로그램은 다음과 같이 rd.read()를 통해 사용자가 입력한 문자를 읽을 수 있음

    ```JAVA
    int c = rd.read(); // 입력 스트림으로부터 키 입력. c는 입력된 키의 문자 값
    ```

* 예를 들어, 사용자가 a, ? 키를 순서대로 입력하면 System.in은 a와 ? 키를 읽고 바이트 정보를 내보냄
* rd는 연속적으로 들어오는 바이트들을 문자로 변환하고 'a', '?' 문자를 응용프로그램에게 전달해 줌
* 스트림은 몇 개라도 연결할 수 있음

## 8.2 문자 스트림과 파일 입출력

### 문자 스트림 클래스

* 문자 스트림은 2바이트의 유니코드 문자를 단위로 입출력하는 스트림
* 문자화되지 않는 바이너리 바이트 값들은 문자 스트림 클래스에서 처리할 수 없음
* 따라서 이미지와 같은 바이너리 정보는 처리할 수 없음
* 문자 입력 스트림은 바이트들을 전달받고, 이 바이트들을 '로컬 문자 집합'에 있는 문자인지 비교하여 문자로 변환함
* 만일 '로컬 문자 집합'에서 찾을 수 없느 ㄴ경우, 문자가 아니거나 다른 언어의 문자들 혹은 문자 집합이 잘못 설정되어 있는 경우임

### FileReader를 이용한 텍스트 파일 읽기

#### ● 파일 입력 스트림 생성

* 먼저 파일 입력 스트림을 생성하고 스트림을 파일과 연결함
* 다음은 FileReader로 파일 입력 스트림을 생성하고, c:\test.txt 파일을 연결하는 예시

    ```JAVA
    FileReader fin = new FileReader("c:\\test.txt");
    ```

* FileReader의 생성자는 c:\test.txt 파일을 찾아 열고, **파일과 스트림을 연결**함

##### FileReader의 생성자

|생성자|설명|
|:---|:---|
|FileReader(File file)|file로부터 읽는 FileReader 생성|
|FileReader(String name)|name 이름의 파일로부터 읽는 FileReader 생성|

#### ● FileReader 파일 읽기

* 파일 입력 스트림(fin)을 이용하여 파일을 읽는 방법은 다음과 같음

    ```JAVA
    int c;
    while((c = fin.read()) != -1) { // 문자 하나를 c에 읽어 들임. 파일 끝까지 반복
        System.out.println((char) c); // 문자 c를 화면에 출력함
        }
    ```

* fin.read()는 연결된 파일로부터 문자 하나를 읽어 리턴하며, 파일의 끝(EOF)를 만나면 -1을 리턴함
* c = fin.read()에서 문자를 읽을 때 2byte unicode 값을 읽어 들이면서도 byte나 char 타입이 아닌, int 타입의 변수 c를 사용하는 이유는 다음과 같음
  * 만일 스트림이나 파일에 0xFF 값이 있다고 하면 read()는 0xFF를 리턴함
  * 0xFF는 -1이지만, read()는 int 타입으로 리턴하므로, 0xFF를 32비트의 0x000000FF로 리턴함
  * 이것은 -1이 아님 → int 타입의 -1은 0xFFFFFFFF임
  * 구분 가능해짐
* 파일이 큰 경우 한 번에 한 문자씩 읽으면 읽는 속도가 너무 느리기 때문에, 다음과 같이 한 번에 블록(버퍼 크기)만큼 읽는 read()를 이용하면 됨

    ```JAVA
    char[] buf = new char[1024]; // 1024는 1kb임
    int n = fin.read(buf); // 한 번에 1024개 문자를 읽어 buf[]에 저장하고 실제 읽은 문자수 리턴
    ```

* 버퍼란 읽고 쓸 데이터를 저장하는 배열을 부르는 용어
* 위에서 파일에 남아 있는 문자의 개수가 1024보다 작을 때, read()는 실제로 읽은 문자의 개수를 리턴함
* 따라서 n < 1024 라면, 파일의 끝까지 읽은 것으로 판단하면 됨

#### ● Reader 스트림 닫기

* 파일 읽기가 더 이상 필요 없으면 다음과 같이 close() 메소드를 호출하여 파일 입력 스트림을 닫음
* 닫힌 스트림으로부터는 더 이상 읽을 수 없음

    ```JAVA
    fin.close();
    ```

##### FileReader, Reader, InputStreamReader의 공통 주요 메소드

|메소드|설명|
|:---|:---|
|int read()|한 개의 문자를 읽어 정수형으로 리턴|
|int read(char[] cbuf)|문자들을 읽어 cbuf 배열에 저장하고 읽은 개수 리턴|
|int read(char[] cbuf, int off, int len)|최대 len 개수의 문자들을 읽어 cbuf 배열의 off 위치부터 저장하고 실제 읽은 개수 리턴|
|String getEncoding()|스트림이 사용하는 문자 집합의 이름 리턴|
|void close()|입력 스트림을 닫고 관련된 시스템 자원 해제|

### 파일 입출력과 예외 처리

* 파일 입출력 실행 중 예외가 발생할 수 있음
    1. 파일의 경로명이 틀린 경우
        * FileReader 생성자는 FileNotFoundException 예외를 발생시킴

            ```JAVA
                FileReader fin = new FileReader("c:\\test.txt"); // FileNotFoundException 발생 가능
            ```

    2. 파일 읽기, 쓰기, 닫기를 하는 동안 입출력 오류가 발생하면, read(), write(), close() 메소드는 IOException 예외를 발생시킴

        ```JAVA
        int c = fin.read(); // IOException 발생 가능
        ```

* 그러므로 파일 입출력 코드에 다음과 같은 try-catch 블록이 필요함

    ```JAVA
    try {
        FileReader fin = new FileReader("c:\\test.txt");
        ...
        int c = fin.read();
        ...
        fin.close();
    } catch (FileNotFoundException e) { // 생략 가능. FileNotFoundException은 IOException을 상속받음
        System.out.println("파일을 열 수 없음");
    } catch (IOException e) {
        System.out.println("입출력 오류");
    }
    ```

### 문자 집합과 InputStreamReader를 이용한 텍스트 파일 읽기

* InputStreamReader는 스트림에 입력되는 바이트 데이터를 문자 집합을 통해 문자로 변환함
* 이를 위해 InputStreamReader의 생성자에 문자 집합을 지정해야 함
* 만일 읽어들인 바이트들이 문자 집합에 속하지 않는 경우 해독할 수 없는 글자가 됨

#### ● InputStreamReader로 문자 입력 스트림 생성

* InputStreamReader는 바이트 스트림을 전달받아 문자 정보로 변환하는 스트림 객체
* 그러므로 우선 텍스트 파일을 읽기 위해서는 다음과 같이 바이트 파일 입력 스트림을 먼저 생성함

    ```JAVA
    FileInputStream fin = new FileInputStream("c:\\Temp\\hangul.txt");    
    ```

* 여기서 c:\Temp\hangul.txt는 메모장으로 작성한 한글 텍스트 파일 → 다음과 같이 InputStreamReader 객체를 생성

    ```JAVA
    InputStreamReader in = new InputStreamReader(fin, "MS949");
    ```

* 생성자 InputStreamReader()의 두 번째 매개변수에는 fin으로부터 읽어 들인 바이트들을 문자로 인코딩하기 위한 문자 집합을 지정함
* 윈도우의 메모장에서 한글 텍스트를 입력하면 디폴트로 마이크로소프트(MS)에서 만든 '한글 확장 완성형 문자 집합'에 있는 코드로 저장함 → MS949

##### InputStreamReader 생성자

|생성자|설명|
|:---|:---|
|InputStreamReader(InputStream in)|in으로부터 읽는 기본 문자 집합의 InputStreamReader 생성|
|InputStreamReader(InputStream in, Charset cs)|in으로부터 읽는 cs 문자 집합의 InputStreamReader 생성|
|InputStreamReader(InputStream in, String charsetName)|in으로부터 읽는 charsetName 문자 집합의 InputStreamReader 생성|

#### ● InputStreamReader 파일 읽기

* in.read()는 문자 집합의 인코딩 규칙에 따라, fin에게 파일로부터 필요한 바이트들을 읽도록 지시하고, 읽어 들인 바이트들을 MS949 문자 집합에 정의된 문자인지 찾아 한글 문자를 리턴함
* 만일 문자 집합에 없는 바이트들인 경우 정상적이지 않은 값을 리턴함

### FileWriter를 이용한 텍스트 파일 쓰기

#### ● 파일 출력 스트림 생성

* c:\Temp\test.txt 파일에 텍스트를 쓰는 출력 스트림 예시

    ```JAVA
    FileWriter fout = new FileWriter("c:\\Temp\\test.txt");
    ```

* FileWriter의 생성자는 c:\Temp\test.txt 파일을 열어 스트림과 연결함
* 파일이 없는 경우 빈 파일을 생성하며, 이미 파일이 있는 경우 파일 내용을 지우고 파일의 처음부터 쓸 준비를 함

##### FileWriter와 OutputStreamWriter의 생성자

|생성자|설명|
|:---|:---|
|OutputStreamWriter(OutputStream out)|out에 출력하는 기본 문자 집합의 OutputStreamWriter 생성|
|OutputStreamWriter(OutputStream out, Charset cs)|out에 출력하는 cs 문자 집합의 OutputStreamWriter 생성|
|OutputStreamWriter(OutputStream out, String charsetName)|charsetName 문자 집합의 OutputStreamWriter 생성|
|FileWriter(File file)|file에 데이터를 저장할 FileWriter 생성|
|FileWriter(String name)|name 파일에 데이터를 저장할 FileWriter 생성|
|FileWriter(File file, boolean append)|FileWriter를 생성하며 append가 true이면 파일의 마지막부터 데이터를 저장|
|FileWriter(String name, boolena append)|FileWriter를 생성하며 append가 true이면 파일의 마지막부터 데이터를 저장|

#### ● Writer 스트림 닫기

* 텍스트를 모두 파일에 저장했으면 close()를 호출하여 스트림을 닫음
* 스트림을 닫으면 연결된 파일도 닫힘

    ```JAVA
    fout.close(); // 스트림을 닫음. 더 이상 스트림에 기록할 수 없음
    ```

##### FileWriter와 OutputStreamWriter의 주요 메소드

|메소드|설명|
|:---|:---|
|void write(int c)|c를 char로 변환하여 한 개의 문자 출력|
|void write(String str)|문자열 str 출력|
|void write(String str, int off, int len)|인덱스 off부터 len개의 문자를 str 문자열에서 출력|
|void write(char[] cbuf, int off, int len)|인덱스 off부터 len개의 문자를 배열 cbuf에서 출력|
|void flush()|스트림에 남아있는 데이터를 모두 출력|
|String getEncoding()|스트림이 사용하는 문자 집합의 이름 리턴|
|void close()|출력 스트림을 닫고 관련된 시스템 자원 해제|

## 8.3 바이트 스트림과 파일 입출력

### 바이트 스트림 클래스

* 바이트 스트림은 바이트 단위로 바이너리 데이터가 흐르는 스트림
* 바이트 스트림은 바이너리 데이터를 있는 그대로 입출력하기 때문에 이미지나 동영상 파일 입출력에 필수적이고, 문자들로 구성된 텍스트 파일도 입출력 할 수 있음

#### ● InputStream/OutputStream

* 추상 클래스이며, 바이트 입출력 처리를 위한 공통 기능을 가진 슈퍼 클래스

#### ● FileInputStream/FileOutputStream

* 파일 입출력을 위한 클래스로서, 파일로부터 바이너리 데이터를 읽거나 파일에 바이너리 데이터를 저장할 수 있음

#### ● DataInputStream/DataOutputStream

* boolean, char, byte, short, int, long, float, doulbe 타입의 값을 바이너리 형태로 입출력하며, 문자열도 바이너리 형태로 입출력함

### FileOutputStream을 이용한 바이너리 파일 쓰기

* 프로그램 내의 변수나 배열이 들어 있는 바이너리 값을 그대로 파일에 저장해야 하는 경우가 있음
* 메모리에 있는 이미지 비트들을 그대로 이미지 파일로 저장하는 경우
* 바이너리 파일은 사람이 읽고 해석하는 것이 거의 불가능

### FileInputStream을 이용한 바이너리 파일 읽기

### 파일 입력 스트림 생성

```JAVA
FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
```

#### ● 파일 읽기

```JAVA
byte[] b = new byte[6]; // 비어있는 배열
int n = 0, c;
while((c = fin.read()) != -1) { // 파일 끝(EOF)까지 한 바이트씩 읽기
    b[n] = (byte)c; // 읽은 바이트를 배열에 저장
    n++;
}
```

#### ● 파일 스트림 닫기

* c:\Temp\test.out에는 한 바이트의 -1(FF)이 들어 있음
* read는 -1(FF)의 한 바이트를 읽어 int 타입의 0x000000FF, 즉 255로 리턴하고 255가 변수 c에 저장됨
* 그리고 나서 c(0x000000FF)와 -1(0xFFFFFFFF)을 비교하여 같지 않은 것으로 판단함
* read()가 파일의 끝을 만날 때 비로소 -1(0xFFFFFFFF)을 리턴하여 반복문 종료
* 이후 close() call

## 8.4 버퍼 입출력과 파일 입출력

### 버퍼 입출력의 필요성

* 입출력 스트림은 운영체제 API를 호출하여 입출력 장치와 프로그램 사이에서 데이터가 전송되도록 함
* 파일 쓰기 메소드는 최종적으로 운영체제 API를 호출하여 파일에 쓰도록 시키고, 운영체제 API는 하드 디스크에 명령을 내려 파일에 데이터를 기록함
* 자주 운영체제 API가 호출될수록 하드 디스크 장치나 네트워크 장치가 자주 작동하게 되어 시스템의 효율은 나빠지고 프로그램 역시 여러 번 입출력을 진행해야 하므로 입출력의 실행 속도가 떨어짐
* 만일 스트림이 버퍼(buffer)를 가지게 되면 보다 효율적으로 작동할 수 있음
* 버퍼란 데이터를 일시적으로 저장하기 위한 메모리
* 파일 출력 스트림이 파일에 쓸 데이터를 버퍼에 모아 두었다가, 한번에 운영체제 API를 호출하여 파일에 쓰게 하면, 운영체제의 부담을 줄이고 장치를 구동하는 일이 줄어들게 되어 시스템의 속도나 효율이 올라가게 됨

### 버퍼 스트림 생성 및 활용

* 버퍼 스트림 클래스의 생성자는 모두 바이트 스트림 또는 문자 스트림과 연결하여 사용함

|생성자 예시|설명|
|:---|:---|
|BufferInputStream(InputStream in)|in을 연결하는 디폴트 크기의 입력 버퍼 스트림 객체 생성|
|BufferWriter(Writer out)|out을 연결하는 디폴트 크기의 문자 출력 버퍼 스트림 생성|

#### ● 버퍼 출력 스트림 생성

#### ● 버퍼에 남아 있는 데이터 출력

* 버퍼 스트림은 버퍼를 가지고 있기 때문에 버퍼가 꽉 찼을 때만 출력되는 특징이 있음
* 그러므로 프로그램에서 데이터를 출력하였지만 버퍼에 들어 있어 출력 장치에 보이지 않을 수 있음
* 버퍼가 다 차지 않은 상태에서 버퍼에 있는 데이터를 강제로 출력 장치로 보내려면 flush() 메소드를 호출하면 됨

#### ● 버퍼 스트림 닫기

## 8.5 File 클래스

### File 클래스란?

* File 클래스는 파일이나 디렉터리에 대해, 경로명, 크기, 타입, 수정 날짜 등의 속성 정보를 제공하고, 파일 삭제, 디렉터리 생성, 파일 이름 변경, 디렉터리 내의 파일 리스트 제공 등 다양한 파일 관리 작업을 지원함
* File 클래스에는 파일 입출력 기능이 없으므로, 파일을 읽고 쓰는 것은 FileInput/OutputStream을 사용

### File 객체 생성

### File 클래스를 이용한 파일 및 디렉터리 관리

#### ● 파일 크기, length()

* length()는 파일이나 디렉터리의 크기를 리턴함

#### ● 파일의 경로명, getName(), getPath(), getParent()

#### ● 파일 타입 판별, isFile()과 isDirectory()

#### ● 디렉터리에 있는 파일 리스트 얻기, listFiles()

* File 객체가 디렉터리의 경로명을 가진 경우, 디렉터리의 모든 파일과 서브디렉터리의 리스틀 얻을 수 있음
* list()는 파일과 서브디렉터리의 경로명을 String[]으로 리턴
* listFiles()는 File[] 리턴

## 8.6 파일 입출력 응용: 파일 복사

### 텍스트 파일 복사

* TextCopyEx.java

### 바이너리 파일 복사

* BinaryCopyEx.java

### 블록 단위로 파일 고속 복사

* 복사 속도를 높이려면 BufferedInput/OutputStream을 사용하든지, 블록 단위로 읽고 쓰도록 수정하면 됨
* BlockBinaryCopyEx.java
