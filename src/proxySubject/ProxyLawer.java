package proxySubject;

import subject.ILawer;

/**
 * Created by Administrator on 2017/2/16.
 */
public class ProxyLawer implements ILawer {
    private ILawer client;

    public ProxyLawer(ILawer client) {
        this.client = client;
    }

    @Override
    public void submit() {
        client.submit();
    }

    @Override
    public void burden() {
        client.burden();
    }

    @Override
    public void defind() {
        client.defind();
    }

    @Override
    public void finish() {
        client.finish();
    }
}
