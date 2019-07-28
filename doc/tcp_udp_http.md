## 1.TCP/UDP协议
#### 1.1 TCP与UDP简介
1.TCP是一种面向字节流，**面向连接**的，**可靠**的协议
<br>
2.UDP是面向报文，**无连接**、**不可靠**的协议

#### 1.2 TCP与UDP区别，优缺点（各自的优点是对方的缺点）
1.TCP:提供确认序列号，确认号，超时重传,也是通过此保证传输的可靠性。UDP不提供。
<br>
2.TCP:只支持单播（点对点）； UDP:支持单播，广播和组播
<br>
3.TCP:保证传输数据的顺序和不重复；UDP不保证
<br>
4.相比于UDP,TCP传输效率更低，耗费资源更大（三次握手和四次挥手）

#### 1.3 TCP和UDP运用场景
1.TCP在通讯质量要求高的时候使用.如：http,SMTP（邮件服务），FTP，ssh
<br>
2.UDP通讯质量要求不高，网络速度要求高的时候使用。如:语音，视频

#### 1.4 TCP三次握手和四次挥手
**1.三次握手**<br>
第一次：客户端向服务端发送(SYN=1, seq=x)，客户端进入SYN_SEND状态<br>
第二次：服务端回传(SYN=1, ACK=1, seq=y, ACKnum=x+1):服务器端进入 SYN_RCVD 状态<br>
第三次：客户端回传(ACK=1，ACKnum=y+1)，发送完毕后，客户端进入 ESTABLISHED 状态，
当服务器端接收到这个包时，也进入 ESTABLISHED 状态，TCP 握手结束。<br>
示意图:<br>
![tcp三次握手](pics/tcp_udp_http/tcp-connection-made-three-way-handshake.png "tcp三次握手图")

**2.四次挥手**<br>
第一次挥手(FIN=1，seq=x)，客户端进入 FIN_WAIT_1 状态不能再发送数据<br>
第二次挥手(ACK=1，ACKnum=x+1)，服务器端进入 CLOSE_WAIT 状态。客户端接收到这个确认包之后，
进入 FIN_WAIT_2 状态，等待服务器端关闭连接。<br>
第三次挥手(FIN=1，seq=y),服务器端准备好关闭连接时，向客户端发送结束连接请求<br>
第四次挥手(ACK=1，ACKnum=y+1)服务器端接收到这个确认包之后，关闭连接，进入 CLOSED 状态。<br>
示意图：<br>
![tcp四次挥手](pics/tcp_udp_http/tcp-connection-closed-four-way-handshake.png "四次挥手")

#### 1.5 TCP SYN攻击(一种典型的 DoS/DDoS 攻击)
1.什么是SYN攻击<br>
三次握手中，当服务端发送确认包后进入半🔗链接状态。SYN 攻击指的是，攻击客户端在短时间内伪造大量不存在的IP地址，向服务器不断地发送SYN包，
服务器回复确认包，并等待客户的确认。此时会在服务端堆积大量半链接的请求，由于源地址是不存在的，服务器需要不断的重发直至超时，
这些伪造的SYN包将长时间占用未连接队列，正常的SYN请求被丢弃，导致目标系统运行缓慢，严重者会引起网络堵塞甚至系统瘫痪。<br>
2.如何检测 SYN 攻击？<br>当你在服务器上看到大量的**半连接状态**时，特别是源IP地址是随机的，基本上可以断定这是一次SYN攻击。
在 Linux/Unix 上可以使用系统自带的 netstats 命令来检测 SYN 攻击。<br>
3.如何防御？<br> 
(1)缩短超时（SYN Timeout）时间,这样可在很大程度上增加废除SYN请求的速度<br>
(2)增加最大半连接数<br>
(3)过滤网关防护<br>
(4)SYN cookies技术

#### 1.6 TCP keepAlive<br>
客户端和服务端之间发送探测包（心跳包），不断确认对方还活着

#### 1.7 参考
* >https://hit-alibaba.github.io/interview/basic/network/TCP.html
* >https://blog.csdn.net/u013777351/article/details/49226101

                                             
                    
