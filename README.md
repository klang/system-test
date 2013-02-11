# system-test

Normally, I would test a system using a mix of cron jobs, ssh connections and perl scripts to autogenerate base line data, this has got to stop.

I have started using clojure for this part of my daily work. Having a REPL running for weeks at the time, only stopping to add another library that I figured I could use in my work.

## Usage

`lein run` will start up nREPL and SWANK on the usual ports. 

The application needs to be able to find something like this in `/etc/hosts`

```bash
192.168.1.10 endjinn.site localhost
endjinn.site localhost
127.0.0.1    localhost
```

otherwise the `(java.net.InetAddress/getLocalHost)` will not work correctly.

(i.e. the machine running the JVM has to be able to look itself up in the local DNS)

## License

Copyright © 2013 Karsten Lang Pedersen

Distributed under the Eclipse Public License, the same as Clojure.
