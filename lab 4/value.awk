BEGIN{
	scount=0;
	rcount=0;
}
{
	if($1=="s" && $3=="_1_" && $4=="AGT")
		scount++;
	if($1=="r" && $3=="_4_" && $4=="AGT")
		rcount++;
}
END{
	printf("The number of packet send %d\n",scount);
	printf("The number of packet received %d\n",rcount);
	printf("The throughput %d\n",rcount/scount*100);
	printf("The number of packet lost %d\n",scount-rcount);
}
