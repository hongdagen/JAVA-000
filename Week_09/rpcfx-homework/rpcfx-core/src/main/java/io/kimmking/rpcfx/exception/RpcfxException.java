package io.kimmking.rpcfx.exception;

/**
 * @Author: hyhy
 * @Date: 2020/12/14 9:35 下午
 */
public class RpcfxException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RpcfxException(Object obj) {
        super(obj.toString());
    }
}
