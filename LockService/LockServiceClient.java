/*
 * Automatically generated by jrpcgen 1.1.3 on 17-5-4 ����10:31
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
package LockService;
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

/**
 * The class <code>LockServiceClient</code> implements the client stub proxy
 * for the LockService remote program. It provides method stubs
 * which, when called, in turn call the appropriate remote method (procedure).
 */
public class LockServiceClient extends OncRpcClientStub {

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy dummy.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient() throws OncRpcException, IOException {
        super(null);
    }

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy object
     * from which the LockService remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient(InetAddress host, int protocol)
           throws OncRpcException, IOException {
        super(host, LockService.LockService, 1, 0, protocol);
    }

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy object
     * from which the LockService remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient(InetAddress host, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, LockService.LockService, 1, port, protocol);
    }

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy object
     * from which the LockService remote program can be accessed.
     * @param client ONC/RPC client connection object implementing a particular
     *   protocol.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient(OncRpcClient client)
           throws OncRpcException, IOException {
        super(client);
    }

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy object
     * from which the LockService remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient(InetAddress host, int program, int version, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, 0, protocol);
    }

    /**
     * Constructs a <code>LockServiceClient</code> client stub proxy object
     * from which the LockService remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public LockServiceClient(InetAddress host, int program, int version, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, port, protocol);
    }

    /**
     * Call remote procedure tryAcquire_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type int).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public int tryAcquire_1(String arg1)
           throws OncRpcException, IOException {
        XdrString args$ = new XdrString(arg1);
        XdrInt result$ = new XdrInt();
        client.call(LockService.tryAcquire_1, LockService.LockServiceVERS, args$, result$);
        return result$.intValue();
    }

}
// End of LockServiceClient.java
