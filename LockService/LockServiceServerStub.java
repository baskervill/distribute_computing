/*
 * Automatically generated by jrpcgen 1.1.3 on 17-5-4 ����10:31
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
package LockService;
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

import org.acplt.oncrpc.server.*;

/**
 */
public abstract class LockServiceServerStub extends OncRpcServerStub implements OncRpcDispatchable {

    public LockServiceServerStub()
           throws OncRpcException, IOException {
        this(0);
    }

    public LockServiceServerStub(int port)
           throws OncRpcException, IOException {
        this(null, port);
    }

    public LockServiceServerStub(InetAddress bindAddr, int port)
           throws OncRpcException, IOException {
        info = new OncRpcServerTransportRegistrationInfo [] {
            new OncRpcServerTransportRegistrationInfo(LockService.LockService, 1),
        };
        transports = new OncRpcServerTransport [] {
            new OncRpcUdpServerTransport(this, bindAddr, port, info, 32768)
            ,
            new OncRpcTcpServerTransport(this, bindAddr, port, info, 32768)
        };
    }

    public void dispatchOncRpcCall(OncRpcCallInformation call, int program, int version, int procedure)
           throws OncRpcException, IOException {
        if ( version == 1 ) {
            switch ( procedure ) {
            case 1: {
                XdrString args$ = new XdrString();
                call.retrieveCall(args$);
                XdrInt result$ = new XdrInt(tryAcquire_1(args$.stringValue()));
                call.reply(result$);
                break;
            }
            case 0: {
                call.retrieveCall(XdrVoid.XDR_VOID);
                call.reply(XdrVoid.XDR_VOID);
                break;
            }
            default:
                call.failProcedureUnavailable();
            }
        } else {
            call.failProgramUnavailable();
        }
    }

    public abstract int tryAcquire_1(String arg1);

}
// End of LockServiceServerStub.java
