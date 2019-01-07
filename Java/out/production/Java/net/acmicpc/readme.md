output 출력하는 몇가지 방법

1. System.out.print 류 사용하는 거 한번 출력엔 빠르지만 여러번 출력하면 오래걸림

2. BufferedWriter 1.번보다는 빠르지만 3.번보다는 느림

3. StringBuilder 개행이 기본으로 안들어가 있음
* sb.append(System.getProperty("line.separator")); 개행은 이거 사용