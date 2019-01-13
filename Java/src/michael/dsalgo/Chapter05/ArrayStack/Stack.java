package michael.dsalgo.Chapter05.ArrayStack;

import michael.dsalgo.Chapter05.Execptions.*;

import java.util.EmptyStackException;

public interface Stack<E> {
    /**
     * 스택 안의 원소 개수를 return
     * @return 스택 안에 있는 원소의 개수
     */
    public int size();

    /**
     * 스택이 비어있는지 아닌지 검사
     * @return 비어있으면 true 비어있지 않으면 false
     */
    public boolean isEmpty();

    /**
     * 스택의 맨 위에 저장되어 있는 원소를 출력, 스택이 비어있으면 원소가 없으므로 Execption을 발생시킴
     * @return 스택의 맨 위에 저장되어 있는 원소를 출력한다.
     * @throws EmptyStackException 스택이 비어있을 때 출력하는 Execption
     */
    public E top()
        throws EmptyStackException;

    /**
     * 스택에 원소를 삽입하는 메서드
     * @param element 스택에 삽입할 원소
     */
    public void push(E element);

    /**
     * 스택의 맨 위에 저장된 원소를 출력하고 삭제, 스택이 비어있으면 원소가 없으므로 Execption을 발생시킴
     * @return 스택의 맨 위에 저장된 원소를 return
     * @throws EmptyStackException 스택이 비어있을 때 출력하는 Execption
     */
    public E pop()
        throws EmptyStackException;
}

