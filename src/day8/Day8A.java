package day8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8A {
	public static void main(String[] args) {
		Registers registers = new Registers();
		String input = "b inc 580 if bkd > -1\n" +
				"v inc 491 if z >= -1\n" +
				"ehd inc 994 if b < 588\n" +
				"oso inc -941 if kfn <= -9\n" +
				"o inc 933 if uly < 8\n" +
				"xn dec 416 if a != -10\n" +
				"uly dec 328 if qur != -6\n" +
				"xn dec 515 if jf > -1\n" +
				"oso dec -542 if hnb > -8\n" +
				"ehd dec -241 if fw != 6\n" +
				"xn dec -416 if a > -2\n" +
				"a dec 92 if b <= 581\n" +
				"he dec -918 if fz <= 1\n" +
				"bkd dec -976 if uly <= -338\n" +
				"z inc 182 if he > 909\n" +
				"dl inc 357 if jf == 0\n" +
				"q dec 531 if kfn != 0\n" +
				"cp inc -475 if rny != 0\n" +
				"hnb dec 800 if fw > -8\n" +
				"hnb dec 950 if he <= 917\n" +
				"he dec 292 if xn == -525\n" +
				"eje dec 818 if yk == 0\n" +
				"v inc -115 if v != 491\n" +
				"a dec -463 if qur == 0\n" +
				"he dec 75 if qur >= 5\n" +
				"a inc 731 if ehd > 1233\n" +
				"a dec -202 if oxv > -7\n" +
				"qur inc 816 if qur > -5\n" +
				"cp inc -636 if bkd < 1\n" +
				"b dec -650 if a != 1303\n" +
				"b inc -337 if xn >= -524\n" +
				"yk dec 200 if bkd <= 5\n" +
				"uly dec -214 if eje <= -825\n" +
				"fw inc 583 if oso == 542\n" +
				"oxv dec 77 if oso >= 536\n" +
				"fz dec 145 if hnb != -792\n" +
				"dl dec -548 if ehd < 1242\n" +
				"qur dec 573 if fz >= -149\n" +
				"o dec 901 if oxv >= -78\n" +
				"qur inc -466 if oxv > -69\n" +
				"q inc 240 if z != 188\n" +
				"uly inc 232 if dl > 899\n" +
				"v dec 760 if uly < -89\n" +
				"eje inc 462 if uly < -90\n" +
				"rny dec -750 if ehd > 1230\n" +
				"ehd inc -858 if ehd < 1226\n" +
				"jf dec 374 if jf >= -6\n" +
				"fz inc -120 if fz == -145\n" +
				"z dec -938 if fw <= 584\n" +
				"o inc 48 if jf != -365\n" +
				"xn inc 793 if v == -269\n" +
				"fw inc -58 if uly > -104\n" +
				"b dec 158 if xn != 284\n" +
				"dl dec 222 if kfn != -7\n" +
				"cp dec -781 if eje == -356\n" +
				"bkd dec -131 if ehd == 1235\n" +
				"dl dec 461 if mf > -9\n" +
				"o inc 971 if fz != -262\n" +
				"fw dec 786 if ehd < 1245\n" +
				"xn dec 221 if eje != -349\n" +
				"cp dec 369 if eje == -356\n" +
				"fz dec -710 if a <= 1310\n" +
				"fw inc -159 if oxv == -77\n" +
				"fw inc -328 if fz != 445\n" +
				"mf dec -356 if mf == 0\n" +
				"bkd dec 750 if ehd > 1229\n" +
				"kfn inc -637 if cp < -228\n" +
				"eje dec 491 if o <= 1053\n" +
				"xn dec 139 if v >= -276\n" +
				"cp dec -316 if he != 918\n" +
				"o inc 430 if fz < 436\n" +
				"oxv dec 257 if yk != -206\n" +
				"fw dec 9 if b != 737\n" +
				"v dec 317 if cp == -224\n" +
				"dl inc -37 if xn < -83\n" +
				"oso dec -65 if uly < -88\n" +
				"q inc -606 if fz == 445\n" +
				"ehd dec 627 if b != 735\n" +
				"xn dec -81 if q == -371\n" +
				"oso inc -576 if oxv >= -336\n" +
				"oxv dec 624 if bkd == -619\n" +
				"xn inc -668 if fw <= -421\n" +
				"he dec -365 if b != 728\n" +
				"ehd inc -73 if b > 734\n" +
				"v inc 338 if uly >= -88\n" +
				"fz dec 342 if v < -578\n" +
				"oso inc -77 if b >= 734\n" +
				"a inc -927 if z < 1126\n" +
				"oso inc 898 if hnb != -803\n" +
				"v dec 208 if qur > 251\n" +
				"qur dec -153 if uly < -87\n" +
				"he dec 678 if dl != 222\n" +
				"fz inc 718 if a > 375\n" +
				"oxv dec 462 if bkd == -619\n" +
				"fw inc 899 if qur >= 394\n" +
				"xn inc 547 if rny <= 744\n" +
				"v dec -863 if fw <= 478\n" +
				"qur inc 676 if jf >= -383\n" +
				"fw dec 964 if he > 1274\n" +
				"bkd dec -63 if v != 277\n" +
				"v inc -313 if qur < 1077\n" +
				"eje inc -576 if kfn != 9\n" +
				"bkd dec 823 if bkd != -616\n" +
				"fw dec -748 if uly > -103\n" +
				"cp inc -962 if fw < 264\n" +
				"q dec -406 if jf == -374\n" +
				"fw dec 871 if rny > 741\n" +
				"oxv dec -654 if fz < 829\n" +
				"rny dec -660 if b < 737\n" +
				"kfn inc -309 if fz != 813\n" +
				"v inc -882 if fw <= -617\n" +
				"b dec -300 if q <= 44\n" +
				"xn inc 462 if z != 1117\n" +
				"o dec 555 if q != 40\n" +
				"z dec -586 if kfn == -309\n" +
				"bkd dec 487 if ehd < 1164\n" +
				"rny dec -795 if xn <= -287\n" +
				"jf inc 511 if cp != -1195\n" +
				"z inc 595 if z == 1706\n" +
				"mf dec 153 if dl == 222\n" +
				"fz inc -297 if yk < -205\n" +
				"uly dec -323 if kfn <= -303\n" +
				"ehd inc 437 if hnb < -790\n" +
				"b inc 101 if oso <= 852\n" +
				"q dec -994 if mf > 203\n" +
				"z inc 504 if oxv == -775\n" +
				"dl dec -298 if o < 1055\n" +
				"he dec -338 if mf < 199\n" +
				"kfn inc -340 if mf < 213\n" +
				"kfn dec 979 if fw >= -620\n" +
				"q dec 258 if rny < 2213\n" +
				"kfn inc -946 if kfn == -1628\n" +
				"yk inc 191 if cp == -1186\n" +
				"q dec 570 if b >= 1133\n" +
				"v inc -223 if jf >= 129\n" +
				"fz dec -858 if yk >= -12\n" +
				"qur inc -872 if v > -1147\n" +
				"bkd inc -333 if uly != 227\n" +
				"yk dec -358 if o <= 1057\n" +
				"a dec -765 if oso <= 855\n" +
				"ehd dec 317 if a <= 1142\n" +
				"yk dec -189 if b == 1136\n" +
				"yk inc 714 if v <= -1133\n" +
				"xn inc -857 if cp < -1180\n" +
				"v dec 724 if ehd > 1275\n" +
				"he dec 41 if oxv == -766\n" +
				"b inc -969 if q >= -788\n" +
				"fz dec 36 if ehd == 1282\n" +
				"oso dec -369 if bkd < -1922\n" +
				"rny dec -958 if xn < -1140\n" +
				"a inc 112 if he == 1248\n" +
				"hnb inc -769 if v == -1865\n" +
				"qur dec -163 if dl < 526\n" +
				"eje dec -753 if jf == 137\n" +
				"ehd inc 6 if a != 1137\n" +
				"bkd inc -529 if v < -1872\n" +
				"he inc -931 if yk != 1246\n" +
				"xn dec 901 if z != 2305\n" +
				"xn inc 739 if xn <= -2044\n" +
				"b inc -859 if ehd > 1278\n" +
				"z inc 518 if b > -690\n" +
				"a dec 662 if qur == 363\n" +
				"oso dec 679 if oso <= 1212\n" +
				"z dec 657 if qur >= 364\n" +
				"o dec 335 if uly <= 236\n" +
				"a dec -213 if fz != 1634\n" +
				"yk inc -57 if rny > 3155\n" +
				"mf dec 622 if eje != -660\n" +
				"oxv dec 854 if z == 2301\n" +
				"o dec 409 if qur > 355\n" +
				"fw dec -50 if mf > -423\n" +
				"v dec -655 if uly <= 235\n" +
				"yk inc -785 if rny > 3162\n" +
				"dl inc 888 if cp != -1190\n" +
				"xn inc 799 if fz != 1652\n" +
				"hnb inc 309 if fw < -565\n" +
				"q dec -731 if kfn == -2574\n" +
				"o dec -407 if dl < 1411\n" +
				"b dec -505 if dl > 1402\n" +
				"v inc -755 if rny < 3165\n" +
				"oxv inc 991 if kfn == -2574\n" +
				"oso inc 408 if v != -1958\n" +
				"b inc 719 if z <= 2303\n" +
				"jf inc -872 if bkd <= -1925\n" +
				"ehd inc 691 if dl >= 1409\n" +
				"qur dec 285 if oxv > -633\n" +
				"fz inc -744 if he >= 313\n" +
				"he dec -490 if hnb <= -1256\n" +
				"eje dec -102 if qur >= 83\n" +
				"o inc -592 if cp > -1183\n" +
				"bkd dec 185 if uly > 218\n" +
				"oso inc -670 if v <= -1969\n" +
				"v inc 163 if oxv >= -620\n" +
				"ehd inc 448 if rny > 3154\n" +
				"fz dec 936 if uly != 217\n" +
				"rny inc 570 if mf == -419\n" +
				"dl dec -644 if xn >= -513\n" +
				"yk dec -132 if o <= 722\n" +
				"uly dec -425 if a >= 685\n" +
				"kfn dec 703 if eje <= -662\n" +
				"uly inc 518 if dl < 2053\n" +
				"o dec -956 if yk <= 532\n" +
				"b inc -46 if kfn != -3273\n" +
				"z dec -194 if fw != -565\n" +
				"b inc 255 if cp == -1186\n" +
				"yk inc 842 if fw >= -574\n" +
				"z inc 662 if eje >= -672\n" +
				"jf inc 907 if z >= 3151\n" +
				"jf dec -499 if bkd == -2114\n" +
				"qur dec 775 if kfn == -3277\n" +
				"kfn dec 212 if mf == -419\n" +
				"yk inc 928 if q > -63\n" +
				"xn inc 56 if fz != 717\n" +
				"oxv inc 939 if o > 713\n" +
				"ehd inc 463 if b < 749\n" +
				"eje inc -707 if xn != -451\n" +
				"cp dec -924 if eje > -1377\n" +
				"qur dec -143 if hnb >= -1267\n" +
				"fz dec 993 if b <= 741\n" +
				"oxv dec 146 if fw <= -563\n" +
				"qur dec 430 if cp == -1189\n" +
				"he inc -438 if rny < 3743\n" +
				"v inc 638 if hnb == -1260\n" +
				"hnb inc 35 if hnb != -1270\n" +
				"dl inc 905 if qur == -554\n" +
				"ehd dec 701 if ehd >= 2194\n" +
				"he dec -330 if dl < 2958\n" +
				"b dec -456 if v > -1323\n" +
				"hnb dec -228 if jf == 671\n" +
				"jf dec -232 if v < -1319\n" +
				"b dec -254 if kfn == -3489\n" +
				"jf inc 591 if o < 715\n" +
				"jf inc 348 if hnb < -1004\n" +
				"z inc -92 if fz != -288\n" +
				"fw inc 573 if mf >= -428\n" +
				"bkd dec -692 if uly > 1163\n" +
				"q inc 898 if uly <= 1172\n" +
				"a dec -469 if qur == -554\n" +
				"ehd inc -903 if eje >= -1379\n" +
				"kfn dec -64 if mf != -425\n" +
				"oxv inc -435 if a == 1162\n" +
				"bkd dec -822 if ehd != 593\n" +
				"hnb dec 757 if cp == -1186\n" +
				"uly dec -939 if fz > -289\n" +
				"fz inc -463 if yk > 2311\n" +
				"o inc -146 if xn < -448\n" +
				"yk dec -17 if rny < 3742\n" +
				"dl inc -899 if fw >= 2\n" +
				"fz dec -982 if fz < -742\n" +
				"he inc 956 if bkd != -605\n" +
				"xn inc 448 if hnb >= -1757\n" +
				"b dec -410 if oxv <= -275\n" +
				"mf dec -752 if kfn < -3420\n" +
				"jf dec 41 if xn >= -4\n" +
				"yk inc 354 if z == 3065\n" +
				"a dec 102 if ehd == 595\n" +
				"he dec -882 if fw < 16\n" +
				"hnb inc 273 if a > 1050\n" +
				"eje dec 259 if ehd != 592\n" +
				"qur dec -339 if v < -1319\n" +
				"oso dec 872 if ehd != 602\n" +
				"bkd dec 812 if q == 851\n" +
				"b inc -936 if eje >= -1633\n" +
				"uly dec 785 if z == 3071\n" +
				"b dec -136 if b <= 1004\n" +
				"fz inc 494 if eje < -1634\n" +
				"uly inc -851 if kfn == -3425\n" +
				"z dec -452 if o <= 569\n" +
				"q inc -942 if fz != 729\n" +
				"kfn dec 877 if xn > 3\n" +
				"hnb dec -748 if he == 2531\n" +
				"b inc 808 if kfn != -3425\n" +
				"dl inc 588 if jf < 1454\n" +
				"he inc -844 if hnb < -733\n" +
				"qur dec -497 if uly != 1265\n" +
				"jf inc 674 if hnb == -733\n" +
				"a dec 560 if v == -1327\n" +
				"fw inc -402 if v > -1333\n" +
				"qur inc -339 if eje == -1636\n" +
				"jf inc 403 if jf == 2127\n" +
				"he dec -575 if b > 1138\n" +
				"v inc -770 if fw >= -397\n" +
				"ehd inc -839 if uly <= 1263\n" +
				"uly dec 606 if cp != -1191\n" +
				"v dec 933 if v >= -2103\n" +
				"dl dec 304 if qur <= -48\n" +
				"b inc 979 if bkd == -600\n" +
				"xn inc 503 if a > 497\n" +
				"mf dec 374 if yk >= 2676\n" +
				"mf dec -153 if a == 500\n" +
				"oso dec 486 if oso <= 756\n" +
				"z dec -962 if rny <= 3724\n" +
				"fz inc 285 if oxv >= -280\n" +
				"oxv inc 380 if v >= -3024\n" +
				"dl inc 214 if z >= 3516\n" +
				"b dec 538 if ehd >= -251\n" +
				"he dec -280 if mf < 105\n" +
				"ehd inc -733 if ehd <= -242\n" +
				"mf inc 592 if yk < 2687\n" +
				"oxv inc -616 if cp == -1186\n" +
				"dl inc 431 if eje > -1632\n" +
				"z inc -582 if qur < -52\n" +
				"oxv dec -56 if qur <= -48\n" +
				"jf dec -615 if bkd > -609\n" +
				"rny inc 394 if eje > -1639\n" +
				"uly inc 888 if qur >= -64\n" +
				"a inc 911 if z < 2927\n" +
				"fz inc -453 if fw >= -399\n" +
				"uly dec -396 if jf > 3144\n" +
				"kfn inc -679 if hnb >= -736\n" +
				"hnb inc 131 if fz == 559\n" +
				"xn inc 957 if qur != -56\n" +
				"bkd dec 793 if q > -99\n" +
				"a inc 533 if cp != -1180\n" +
				"yk inc -231 if q != -96\n" +
				"bkd inc -866 if oxv <= -823\n" +
				"a inc -851 if yk != 2452\n" +
				"z dec 614 if cp > -1189\n" +
				"a dec 444 if bkd != -1460\n" +
				"uly inc -413 if fz > 556\n" +
				"eje inc 245 if rny < 4137\n" +
				"fw dec -254 if oso >= 754\n" +
				"fz inc -772 if yk != 2452\n" +
				"fz dec -621 if oso < 766\n" +
				"ehd dec -277 if q == -101\n" +
				"cp inc 319 if oso < 748\n" +
				"kfn inc 758 if a != 592\n" +
				"z dec 459 if eje < -1400\n" +
				"oxv dec -425 if rny <= 4136\n" +
				"kfn inc 880 if dl != 2550\n" +
				"ehd inc -35 if xn < 1453\n" +
				"uly dec -935 if jf <= 3147\n" +
				"dl dec 969 if oso >= 761\n" +
				"b inc -458 if a == 589\n" +
				"mf inc 471 if oxv < -410\n" +
				"v inc -82 if oso >= 749\n" +
				"mf inc -87 if q >= -102\n" +
				"z dec -814 if hnb == -600\n" +
				"jf dec 735 if qur <= -56\n" +
				"cp inc 565 if v != -3115\n" +
				"fz dec 771 if hnb == -602\n" +
				"fz dec -215 if mf <= 618\n" +
				"ehd dec -941 if mf > 617\n" +
				"dl dec 677 if a <= 591\n" +
				"rny inc 124 if eje == -1391\n" +
				"qur inc 683 if rny != 4251\n" +
				"rny inc 435 if eje == -1391\n" +
				"fw dec -641 if z < 2331\n" +
				"rny dec -70 if cp < -616\n" +
				"hnb dec -153 if xn >= 1456\n" +
				"kfn dec 829 if ehd != -692\n" +
				"rny dec 208 if fw < 505\n" +
				"xn inc -410 if qur != -57\n" +
				"eje inc 255 if ehd != -690\n" +
				"mf dec -103 if v < -3109\n" +
				"dl inc -552 if eje > -1134\n" +
				"rny inc 73 if z >= 2323\n" +
				"ehd inc -770 if rny > 4540\n" +
				"uly dec -937 if z >= 2314\n" +
				"eje dec -227 if he == 2531\n" +
				"z dec -32 if eje > -917\n" +
				"b dec 956 if oxv <= -400\n" +
				"o inc 924 if jf >= 2410\n" +
				"dl dec 162 if ehd != -1477\n" +
				"fw dec -901 if z != 2354\n" +
				"qur dec 724 if oso <= 763\n" +
				"oxv dec -778 if a < 598\n" +
				"eje dec -603 if qur < -777\n" +
				"oxv inc 473 if fz == 624\n" +
				"kfn dec -990 if a == 589\n" +
				"eje dec -38 if fz < 625\n" +
				"z inc 915 if qur == -788\n" +
				"fw dec -233 if fz > 624\n" +
				"uly dec -132 if dl != 1710\n" +
				"uly inc -333 if xn == 1456\n" +
				"z dec -342 if z == 2353\n" +
				"bkd dec 695 if oxv == 846\n" +
				"oso dec 198 if z < 2694\n" +
				"b dec -985 if a == 589\n" +
				"eje inc 581 if rny > 4542\n" +
				"eje inc 705 if cp != -621\n" +
				"a dec -249 if eje == 317\n" +
				"eje dec -814 if bkd < -1461\n" +
				"jf dec -361 if xn < 1451\n" +
				"oxv inc 982 if he <= 2534\n" +
				"cp inc 630 if v <= -3105\n" +
				"z inc -818 if eje <= 1130\n" +
				"z inc -363 if dl == 1710\n" +
				"fz dec -165 if eje >= 1119\n" +
				"bkd inc 860 if rny == 4549\n" +
				"ehd dec -385 if xn < 1452\n" +
				"bkd inc 52 if oxv < 1829\n" +
				"uly dec 726 if dl != 1724\n" +
				"oso dec -244 if a <= 596\n" +
				"uly inc -662 if kfn < -2314\n" +
				"z dec -84 if ehd < -1461\n" +
				"b inc -98 if kfn == -2305\n" +
				"eje dec 803 if dl >= 1710\n" +
				"fz inc 721 if o <= 1497\n" +
				"o dec 377 if a < 599\n" +
				"ehd inc -556 if o < 1107\n" +
				"dl inc -456 if yk != 2451\n" +
				"bkd dec 98 if uly > 2458\n" +
				"jf inc -375 if fz >= 1510\n" +
				"fz inc 27 if yk != 2452\n" +
				"fw inc 582 if yk == 2452\n" +
				"he inc 743 if rny == 4555\n" +
				"ehd dec -926 if xn >= 1448\n" +
				"ehd dec -486 if hnb >= -452\n" +
				"rny inc 515 if qur != -779\n" +
				"bkd inc 220 if bkd < -1504\n" +
				"eje inc 996 if oso < 1009\n" +
				"bkd dec 610 if uly != 2467\n" +
				"eje inc -136 if v < -3102\n" +
				"oxv inc -97 if ehd == -56\n" +
				"he inc -525 if bkd >= -1906\n" +
				"rny inc -470 if yk <= 2452\n" +
				"he inc 81 if dl > 1265\n" +
				"dl dec -535 if kfn == -2305\n" +
				"qur inc -147 if a < 585\n" +
				"mf dec 729 if b > 1038\n" +
				"yk inc 548 if b != 1053\n" +
				"he inc -515 if ehd < -48\n" +
				"oxv inc -593 if b > 1042\n" +
				"rny dec -973 if fz > 1500\n" +
				"jf inc -920 if a < 590\n" +
				"cp dec -102 if kfn <= -2296\n" +
				"he dec -849 if uly > 2459\n" +
				"kfn inc 831 if he >= 2339\n" +
				"xn dec -524 if mf != -9\n" +
				"z dec -503 if ehd <= -61\n" +
				"eje inc 60 if yk <= 3003\n" +
				"yk inc -576 if yk > 3007\n" +
				"cp dec 704 if yk <= 3006\n" +
				"bkd dec 364 if v <= -3104\n" +
				"a inc 166 if uly >= 2476\n" +
				"z inc 313 if a != 591\n" +
				"rny inc 914 if mf == -9\n" +
				"a inc 897 if rny <= 6486\n" +
				"cp inc 644 if qur >= -789\n" +
				"a dec 659 if v >= -3112\n" +
				"v inc -95 if ehd <= -68\n" +
				"fw dec -172 if bkd >= -2270\n" +
				"yk dec -692 if mf == -9\n" +
				"o inc -722 if yk == 3701\n" +
				"q inc 640 if cp == 51\n" +
				"hnb dec 886 if dl == 1796\n" +
				"yk inc 563 if q == 547\n" +
				"oxv inc -20 if jf >= 1113\n" +
				"oxv dec 650 if he < 2347\n" +
				"oso dec 123 if z <= 2277\n" +
				"dl dec 442 if q < 539\n" +
				"oso inc -190 if cp > 41\n" +
				"eje dec -89 if oso >= 696\n" +
				"z inc -840 if bkd <= -2257\n" +
				"oxv dec 367 if qur < -777\n" +
				"fw dec 924 if eje >= 1244\n" +
				"b inc 567 if yk >= 3686\n" +
				"oso inc -512 if bkd >= -2258\n" +
				"dl dec -615 if v < -3102\n" +
				"he dec -129 if b <= 1616\n" +
				"uly inc -214 if cp >= 49\n" +
				"v dec -131 if oso < 696\n" +
				"he inc -440 if jf < 1118\n" +
				"bkd dec 16 if fz >= 1510\n" +
				"xn inc -235 if oso <= 697\n" +
				"a inc 808 if uly <= 2261\n" +
				"jf dec 578 if fw < 1239\n" +
				"cp dec -673 if oso >= 680\n" +
				"fz inc -542 if oso < 696\n" +
				"dl inc 411 if mf != -17\n" +
				"b dec -915 if cp >= 724\n" +
				"qur inc 460 if oxv <= 205\n" +
				"fz dec 643 if bkd < -2287\n" +
				"oxv dec 187 if eje > 1240\n" +
				"qur inc 583 if uly > 2245\n" +
				"kfn inc -504 if z <= 1428\n" +
				"dl inc -794 if mf <= -2\n" +
				"eje inc 225 if v < -2979\n" +
				"oso inc -138 if dl >= 2022\n" +
				"he dec 978 if xn <= 1230\n" +
				"o inc 652 if a <= 1634\n" +
				"o inc 699 if v > -2987\n" +
				"fz inc -433 if b != 2527\n" +
				"z inc -915 if bkd == -2272\n" +
				"b inc -74 if b < 2531\n" +
				"qur dec -889 if eje == 1469\n" +
				"rny inc -672 if hnb > -1334\n" +
				"cp inc -508 if fz > 961\n" +
				"uly dec -766 if bkd >= -2282\n" +
				"uly dec 206 if uly < 3028\n" +
				"b inc -5 if fz == 968\n" +
				"b dec -612 if qur < 1154\n" +
				"eje inc 719 if he > 1059\n" +
				"eje dec -705 if yk <= 3695\n" +
				"q dec -764 if z > 1443\n" +
				"rny dec 512 if oso <= 552\n" +
				"rny inc 50 if fw <= 1236\n" +
				"he dec 3 if uly != 2815\n" +
				"rny inc -73 if dl >= 2019\n" +
				"fw dec -474 if rny >= 5940\n" +
				"he dec 226 if rny == 5945\n" +
				"rny inc 674 if uly == 2814\n" +
				"z inc 522 if yk < 3699\n" +
				"mf inc -278 if yk > 3686\n" +
				"oxv dec -916 if dl == 2020\n" +
				"mf dec -560 if rny > 6613\n" +
				"bkd dec 966 if qur <= 1151\n" +
				"xn dec -808 if oso != 555\n" +
				"oxv inc 86 if b > 3061\n" +
				"fw dec -140 if oso < 544\n" +
				"he dec 299 if q <= 540\n" +
				"he dec 236 if oso <= 553\n" +
				"oxv dec 117 if z > 1961\n" +
				"fz inc -244 if cp <= 218\n" +
				"v dec -451 if b != 3056\n" +
				"qur dec -532 if uly > 2805\n" +
				"mf dec 882 if cp == 216\n" +
				"b dec -863 if cp < 220\n" +
				"q dec 702 if z > 1946\n" +
				"rny dec 447 if rny == 6619\n" +
				"uly inc 198 if mf <= -608\n" +
				"q dec 242 if yk > 3682\n" +
				"mf inc -682 if yk > 3701\n" +
				"z dec 255 if q < -414\n" +
				"jf inc -571 if oxv >= 3\n" +
				"rny dec 891 if he >= 283\n" +
				"cp dec -355 if yk != 3692\n" +
				"kfn inc 119 if fz > 717\n" +
				"jf inc -102 if jf != -40\n" +
				"he dec -728 if oxv >= 7\n" +
				"kfn dec -119 if mf < -604\n" +
				"mf dec -567 if uly < 3018\n" +
				"z inc -618 if jf <= -132\n" +
				"a inc -977 if he == 1015\n" +
				"q inc 817 if z >= 1332\n" +
				"a inc 333 if fw > 1710\n" +
				"v dec 36 if fz != 717\n" +
				"eje inc -93 if jf < -127\n" +
				"oxv dec -699 if a < 659\n" +
				"kfn inc 390 if oso != 540\n" +
				"v inc 704 if q > 409\n" +
				"ehd dec 390 if oxv != 709\n" +
				"o dec -382 if v < -1858\n" +
				"xn dec -907 if uly >= 3005\n" +
				"jf dec 56 if a >= 649\n" +
				"oso dec -6 if a < 662\n" +
				"bkd inc 383 if fw == 1695\n" +
				"oxv dec -112 if oso != 552\n" +
				"mf dec -906 if rny > 5279\n" +
				"fz inc 3 if qur > 1687\n" +
				"bkd inc 705 if fw == 1704\n" +
				"z dec 964 if oso >= 547\n" +
				"o dec 292 if eje == 2081\n" +
				"uly dec 77 if o < 1911\n" +
				"eje inc 152 if dl < 2032\n" +
				"o inc 179 if b == 3923\n" +
				"dl dec 364 if fz == 724\n" +
				"ehd inc 776 if z != 374\n" +
				"yk inc -533 if uly < 2943\n" +
				"q inc -248 if rny == 5281\n" +
				"kfn dec -416 if fz >= 724\n" +
				"cp inc -695 if bkd >= -2551\n" +
				"q dec 405 if v == -1862\n" +
				"z inc -715 if kfn <= -427\n" +
				"yk dec 427 if z != -345\n" +
				"xn dec 374 if oxv > 828\n" +
				"a dec -920 if oxv <= 825\n" +
				"xn dec -532 if a != 1581\n" +
				"rny dec 308 if b <= 3932\n" +
				"eje dec -335 if v == -1862\n" +
				"oso inc 890 if jf >= -197\n" +
				"mf dec 390 if o >= 2083\n" +
				"o inc 558 if qur != 1691\n" +
				"oxv inc 707 if dl == 1664\n" +
				"xn dec -319 if fw <= 1711\n" +
				"uly dec -19 if ehd <= -64\n" +
				"o inc 283 if mf != 468\n" +
				"bkd inc -192 if fz < 733\n" +
				"bkd dec -73 if a < 1585\n" +
				"mf dec 935 if fw <= 1708\n" +
				"cp dec -972 if xn >= 3782\n" +
				"mf inc 639 if hnb == -1335\n" +
				"mf inc 416 if eje >= 2571\n" +
				"rny dec 446 if kfn < -421\n" +
				"hnb inc -103 if yk <= 2733\n" +
				"bkd dec -766 if qur <= 1677\n" +
				"oso dec -820 if jf == -192\n" +
				"a inc -628 if dl > 1671\n" +
				"ehd dec -982 if v <= -1870\n" +
				"q dec -615 if hnb > -1437\n" +
				"a dec -201 if kfn == -430\n" +
				"jf inc 806 if fz >= 721\n" +
				"he dec 129 if yk == 2732\n" +
				"bkd dec 574 if kfn < -424\n" +
				"fz dec -655 if eje < 2578\n" +
				"a inc -618 if q > -249\n" +
				"qur dec -382 if z <= -334\n" +
				"z inc -433 if uly < 2941\n" +
				"v dec 83 if qur <= 2057\n" +
				"jf dec 435 if jf != 621\n" +
				"kfn dec 516 if q >= -246\n" +
				"q inc -799 if z < -780\n" +
				"yk dec 422 if uly == 2935\n" +
				"fw inc 192 if yk <= 2311\n" +
				"eje dec -318 if fz <= 1381\n" +
				"yk inc -731 if z != -774\n" +
				"kfn inc 88 if yk == 2310\n" +
				"a inc -450 if uly <= 2935\n" +
				"fz dec 108 if kfn <= -868\n" +
				"uly inc -324 if v <= -1856\n" +
				"eje inc -131 if yk >= 2312\n" +
				"b dec 212 if rny < 4533\n" +
				"qur dec -754 if qur >= 2065\n" +
				"qur dec 416 if xn != 3790\n" +
				"he inc -327 if bkd <= -3243\n" +
				"fz inc -695 if bkd < -3234\n" +
				"b inc 121 if z > -773\n" +
				"rny inc 747 if oxv == 1528\n" +
				"bkd dec 860 if rny == 5274\n" +
				"xn dec -666 if cp != 484\n" +
				"xn inc -259 if qur < 2402\n" +
				"oxv inc 275 if fz <= 678\n" +
				"yk inc 540 if v >= -1871\n" +
				"kfn inc 515 if uly < 2615\n" +
				"dl dec 848 if b != 3717\n" +
				"z dec 613 if mf < 184\n" +
				"v dec -222 if q == -241\n" +
				"cp inc 49 if he >= 878\n" +
				"v inc -528 if xn > 4443\n" +
				"he inc -720 if oso == 2266\n" +
				"o inc -3 if he > 162\n" +
				"kfn inc -986 if jf <= 175\n" +
				"yk inc -299 if o < 2927\n" +
				"cp dec 983 if fz <= 689\n" +
				"eje dec 843 if eje <= 2888\n" +
				"v inc 129 if cp < -434\n" +
				"qur inc 868 if xn < 4459\n" +
				"eje dec 847 if rny >= 5273\n" +
				"o inc 936 if hnb > -1436\n" +
				"bkd dec 895 if bkd >= -4098\n" +
				"jf dec 101 if a != 711\n" +
				"b inc 817 if xn < 4461\n" +
				"oso dec 513 if eje > 1189\n" +
				"uly dec 474 if qur != 3271\n" +
				"rny inc -173 if hnb >= -1430\n" +
				"b dec 864 if q <= -234\n" +
				"mf inc -162 if hnb == -1438\n" +
				"eje inc 770 if rny < 5267\n" +
				"cp dec 430 if oso < 1759\n" +
				"jf inc 770 if jf > 177\n" +
				"qur inc -699 if v > -2045\n" +
				"hnb dec 810 if ehd != -51\n" +
				"cp inc -97 if z <= -1382\n" +
				"oso dec -955 if kfn <= -341\n" +
				"oxv dec -38 if fz >= 684\n" +
				"b inc 195 if fz <= 691\n" +
				"ehd inc 662 if o == 2921\n" +
				"bkd dec -983 if cp <= -978\n" +
				"rny inc 280 if fz == 681\n" +
				"v dec 488 if xn < 4457\n" +
				"qur dec 549 if oxv != 1562\n" +
				"he dec -128 if fz <= 693\n" +
				"jf dec -14 if qur == 2023\n" +
				"cp inc -208 if o <= 2923\n" +
				"dl inc -20 if kfn >= -345\n" +
				"hnb inc -812 if qur != 2022\n" +
				"oxv inc -903 if a == 711\n" +
				"xn dec 383 if ehd >= 599\n" +
				"oso inc -858 if hnb >= -3063\n" +
				"eje inc -742 if eje > 1200\n" +
				"qur dec -870 if v < -2524\n" +
				"yk dec -290 if v < -2533\n" +
				"eje inc -212 if oso <= 1844\n" +
				"uly inc -85 if uly < 2619\n" +
				"dl dec -555 if cp != -1174\n" +
				"fz dec -516 if eje <= 1198\n" +
				"z dec -338 if oso >= 1854\n" +
				"b inc -175 if fz <= 1207\n" +
				"v dec -571 if he != 292\n" +
				"o dec -84 if jf != 959\n" +
				"jf dec 63 if jf > 962\n" +
				"cp inc -772 if dl == 1351\n" +
				"z inc 93 if v <= -1954\n" +
				"kfn inc 984 if ehd > 594\n" +
				"dl inc 410 if he >= 288\n" +
				"uly dec 203 if v < -1956\n" +
				"qur inc 334 if a == 711\n" +
				"q inc 749 if eje > 1205\n" +
				"q dec 874 if ehd > 605\n" +
				"mf inc -842 if cp == -1948\n" +
				"rny dec 789 if xn >= 4070\n" +
				"cp dec 7 if ehd < 600\n" +
				"bkd inc 491 if a >= 715\n" +
				"yk inc -399 if ehd <= 604\n" +
				"ehd dec 579 if he == 294\n" +
				"yk inc 957 if he >= 294\n" +
				"he dec 456 if uly > 2529\n" +
				"jf inc 944 if uly >= 2521\n" +
				"rny dec 51 if rny >= 4481\n" +
				"z inc 890 if fw == 1896\n" +
				"v inc -773 if cp >= -1950\n" +
				"z dec 156 if xn == 4076\n" +
				"v inc -466 if a < 720\n" +
				"mf inc -888 if a >= 705\n" +
				"b inc -636 if kfn >= 637\n" +
				"oso dec 430 if rny > 4433\n" +
				"uly inc 661 if v == -3195\n" +
				"qur dec 278 if xn == 4070\n" +
				"oxv dec -487 if o >= 2997\n" +
				"mf dec -930 if cp > -1951\n" +
				"mf dec 712 if rny > 4432\n" +
				"oxv inc -287 if he >= 290\n" +
				"eje inc -84 if xn == 4070\n" +
				"fz dec -637 if yk <= 3117\n" +
				"a inc 762 if jf <= 1847\n" +
				"a dec 849 if o != 2995\n" +
				"oxv inc -946 if fw <= 1897\n" +
				"qur inc 870 if mf <= -1491\n" +
				"xn inc -65 if yk > 3110\n" +
				"he inc 96 if qur > 3823\n" +
				"kfn inc -701 if z == -404\n" +
				"bkd inc 973 if yk > 3100\n" +
				"yk inc -632 if rny != 4441\n" +
				"fw inc 616 if jf < 1846\n" +
				"v dec -57 if xn == 4070\n" +
				"dl inc 913 if ehd == 25\n" +
				"oso inc -901 if ehd < 24\n" +
				"qur dec -690 if o == 3005\n" +
				"jf dec 24 if eje <= 1102\n" +
				"fw inc 119 if b <= 3043\n" +
				"kfn inc 319 if a > 631\n" +
				"fz dec 527 if kfn < -52\n" +
				"yk dec 691 if mf != -1487\n" +
				"qur dec -798 if ehd >= 17\n" +
				"yk inc -191 if q == -241\n" +
				"ehd dec 270 if mf > -1506\n" +
				"oxv dec 633 if mf < -1495\n" +
				"mf inc -893 if q > -248\n" +
				"v dec 774 if he >= 298\n" +
				"a inc -972 if dl > 2673\n" +
				"z inc 533 if z == -404\n" +
				"rny inc -80 if ehd != -252\n" +
				"hnb dec -189 if b >= 3040\n" +
				"xn dec -197 if fw != 2512\n" +
				"uly inc 579 if xn >= 4068\n" +
				"uly dec 407 if uly <= 3767\n" +
				"fw inc 953 if fw > 2504\n" +
				"yk dec 412 if qur != 5304\n" +
				"jf inc -40 if rny <= 4358\n" +
				"oxv dec -794 if he == 303\n" +
				"oxv dec 598 if eje <= 1115\n" +
				"dl inc -216 if z == 129\n" +
				"kfn dec 615 if uly != 3359\n" +
				"z dec -32 if a < -341\n" +
				"v dec 281 if z > 156\n" +
				"b inc -903 if a >= -356\n" +
				"he inc -801 if z <= 163\n" +
				"oso inc 138 if kfn > -58\n" +
				"a dec 313 if he < -497\n" +
				"fz inc 11 if kfn < -55\n" +
				"cp dec 412 if oxv <= -1305\n" +
				"qur dec -811 if xn != 4078\n" +
				"o inc -322 if b <= 2143\n" +
				"jf inc 275 if bkd > -4020\n" +
				"b inc -847 if ehd != -240\n" +
				"cp dec 205 if q > -248\n" +
				"bkd inc 579 if fw != 3470\n" +
				"oso inc 934 if uly < 3368\n" +
				"z inc -740 if he <= -503\n" +
				"hnb inc -339 if o != 3005\n" +
				"yk inc 574 if rny < 4358\n" +
				"he dec -579 if oxv < -1310\n" +
				"a inc -29 if yk <= 1765\n" +
				"q dec -147 if eje < 1105\n" +
				"uly dec 987 if a >= -694\n" +
				"a dec 40 if eje < 1110\n" +
				"q inc -426 if ehd <= -244\n" +
				"cp dec -4 if hnb == -2871\n" +
				"fw inc -258 if fz >= 1316\n" +
				"he dec -792 if xn <= 4070\n" +
				"kfn inc -616 if ehd > -250\n" +
				"cp inc 332 if z == -582\n" +
				"fz inc -556 if rny >= 4350\n" +
				"rny inc -219 if oso >= 2347\n" +
				"xn inc 205 if rny == 4135\n" +
				"fz dec 793 if dl < 2468\n" +
				"ehd dec 856 if hnb >= -2879\n" +
				"bkd inc -659 if cp > -2569\n" +
				"dl dec 697 if oxv != -1314\n" +
				"xn dec -609 if z <= -572\n" +
				"he dec 988 if rny > 4127\n" +
				"dl inc 942 if xn >= 4883\n" +
				"mf dec 401 if fz == -28\n" +
				"o dec -818 if o >= 2997\n" +
				"fz inc 731 if oso != 2354\n" +
				"fw inc 722 if uly <= 2380\n" +
				"kfn inc 577 if v != -3411\n" +
				"mf inc -469 if dl > 3393\n" +
				"oso dec -742 if he != -124\n" +
				"hnb inc 74 if jf <= 2073\n" +
				"z dec 532 if rny < 4145\n" +
				"kfn dec 398 if he < -115\n" +
				"q inc 725 if cp > -2557\n" +
				"b inc 733 if o != 3831\n" +
				"hnb inc 869 if eje < 1120\n" +
				"xn dec -254 if uly > 2362\n" +
				"hnb dec -117 if eje != 1107\n" +
				"v dec 220 if fw < 3930\n" +
				"fw dec 801 if dl <= 3404\n" +
				"rny inc 122 if mf < -3254\n" +
				"yk dec -405 if q > -675\n" +
				"fz dec -992 if oso != 2361\n" +
				"v inc -524 if dl != 3400\n" +
				"mf inc -233 if q > -674\n" +
				"rny inc 957 if a > -685\n" +
				"oso inc 803 if z != -1104\n" +
				"eje inc 254 if mf < -3486\n" +
				"kfn inc -242 if fw >= 3119\n" +
				"b inc 805 if q != -667\n" +
				"xn dec -243 if oso >= 3156\n" +
				"yk dec 950 if o <= 3828\n" +
				"ehd dec -132 if qur < 6125\n" +
				"jf inc -908 if jf > 2070\n" +
				"ehd dec 858 if kfn > -736\n" +
				"mf dec 933 if bkd > -4103\n" +
				"fw dec 25 if hnb <= -1882\n" +
				"fz inc -16 if o != 3827\n" +
				"v inc 950 if he <= -116\n" +
				"v inc -547 if he >= -128\n" +
				"oxv inc 341 if mf > -4425\n" +
				"z dec 532 if fw < 3105\n" +
				"kfn dec 521 if dl > 3394\n" +
				"dl inc -301 if eje >= 1364\n" +
				"dl inc 510 if fz > 951\n" +
				"o dec 120 if oso == 3167\n" +
				"yk dec -333 if q > -666\n" +
				"fz dec -909 if o != 3825\n" +
				"fz dec 802 if bkd > -4103\n" +
				"bkd dec -791 if q < -666\n" +
				"oso inc -33 if kfn <= -1257\n" +
				"jf inc 194 if fz != 1058\n" +
				"z dec 490 if a < -682\n" +
				"a inc -813 if v > -3244\n" +
				"a inc 759 if hnb != -1881\n" +
				"b inc -208 if qur == 6118\n" +
				"qur dec 290 if he != -131\n" +
				"a dec -326 if z != -2133\n" +
				"rny dec 311 if qur != 5838\n" +
				"uly dec -692 if qur < 5835\n" +
				"mf dec 443 if uly != 3060\n" +
				"uly inc -455 if hnb != -1891\n" +
				"bkd inc 504 if eje != 1364\n" +
				"fw dec 233 if he < -119\n" +
				"dl dec -222 if uly > 2607\n" +
				"yk inc 39 if q >= -669\n" +
				"he inc -814 if oxv > -1322\n" +
				"dl dec -131 if a != -746\n" +
				"ehd inc 808 if rny < 3950\n" +
				"qur inc -110 if xn == 5381\n" +
				"dl inc -749 if cp < -2554\n" +
				"jf dec -887 if xn < 5382\n" +
				"fw inc 62 if fz <= 1058\n" +
				"fw dec -213 if dl >= 2694\n" +
				"o inc 797 if jf <= 2257\n" +
				"eje inc -100 if dl < 2711\n" +
				"rny inc 223 if a != -744\n" +
				"q inc -262 if uly != 2605\n" +
				"oso inc 336 if fz != 1056\n" +
				"kfn inc -847 if a != -750\n" +
				"fw inc 943 if o > 4612\n" +
				"jf dec 823 if mf <= -4867\n" +
				"oxv dec -189 if he <= -937\n" +
				"he dec 85 if hnb != -1894\n" +
				"jf dec 522 if he == -1023\n" +
				"ehd dec -995 if he > -1029\n" +
				"rny dec -315 if yk <= 1245\n" +
				"xn inc -424 if z == -2134\n" +
				"eje inc 421 if cp >= -2567\n" +
				"xn dec -187 if he != -1028\n" +
				"eje inc 539 if dl <= 2710\n" +
				"jf inc 34 if oxv >= -1117\n" +
				"v inc -787 if qur == 5718\n" +
				"cp inc -927 if mf < -4859\n" +
				"oxv inc -366 if xn > 5559\n" +
				"mf dec 0 if yk <= 1247\n" +
				"z dec -963 if hnb >= -1886\n" +
				"mf inc 173 if q < -938\n" +
				"a dec 294 if dl >= 2698\n" +
				"kfn dec 910 if cp <= -3481\n" +
				"rny dec 529 if eje <= 2216\n" +
				"fw dec -621 if a > -1048\n" +
				"rny inc 235 if hnb < -1880\n" +
				"q dec -303 if cp == -3488\n" +
				"cp dec 882 if oxv > -1499\n" +
				"uly inc -941 if fz >= 1046\n" +
				"z inc -595 if eje <= 2228\n" +
				"eje inc 131 if bkd == -2803\n" +
				"oxv inc -201 if z < -1756\n" +
				"kfn inc -775 if a != -1031\n" +
				"mf inc 724 if z <= -1765\n" +
				"o inc 178 if rny == 4181\n" +
				"z dec -365 if fw <= 4714\n" +
				"mf inc 273 if yk < 1253\n" +
				"z inc 516 if ehd < 830\n" +
				"he dec 519 if b < 1818\n" +
				"dl dec -131 if fz > 1061\n" +
				"eje inc -335 if dl > 2700\n" +
				"v inc -945 if fz == 1055\n" +
				"ehd dec -550 if oxv >= -1701\n" +
				"hnb inc 803 if mf < -3865\n" +
				"v dec 321 if rny == 4181\n" +
				"z inc 770 if dl <= 2705\n" +
				"cp dec -667 if fz > 1061\n" +
				"jf inc 629 if he == -1019\n" +
				"z inc 304 if eje >= 2018\n" +
				"a dec 793 if he <= -1014\n" +
				"bkd dec 507 if yk < 1257\n" +
				"dl inc -628 if dl >= 2700\n" +
				"xn inc -488 if fz < 1063\n" +
				"rny dec 607 if fw < 4719\n" +
				"z dec -202 if o > 4806\n" +
				"bkd inc -93 if kfn < -3790\n" +
				"jf dec 813 if kfn == -3786\n" +
				"he inc 749 if ehd >= 1381\n" +
				"rny inc 447 if hnb != -1081\n" +
				"yk dec 298 if a >= -1840\n" +
				"cp dec 377 if xn <= 5084\n" +
				"eje dec 625 if rny < 4024\n" +
				"jf inc -15 if jf != 907\n" +
				"qur inc 893 if z > -329\n" +
				"oxv inc 941 if dl <= 2075\n" +
				"ehd dec 994 if yk != 953\n" +
				"yk inc 941 if z > -329\n" +
				"rny dec -661 if bkd > -3394\n" +
				"fz dec 374 if z > -325\n" +
				"oxv dec -606 if bkd < -3393\n" +
				"cp dec -671 if qur >= 6619\n" +
				"oxv inc -794 if oso <= 3467\n" +
				"oso dec -315 if b == 1823\n" +
				"eje dec 550 if rny > 4029\n" +
				"fw inc 7 if z >= -334\n" +
				"kfn dec 101 if uly >= 1661\n" +
				"oso inc 322 if mf != -3862\n" +
				"qur dec -4 if bkd == -3410\n" +
				"jf inc 763 if cp < -4746\n" +
				"v inc 758 if bkd == -3403\n" +
				"v inc 860 if bkd != -3403\n" +
				"q dec -107 if oso > 4088\n" +
				"dl dec -840 if oso <= 4095\n" +
				"xn inc -296 if ehd != 1376\n" +
				"mf dec -986 if v == -4531\n" +
				"fz inc 861 if o == 4798\n" +
				"v dec 977 if ehd != 1386\n" +
				"mf inc -508 if ehd == 1384\n" +
				"o dec 48 if cp < -4738\n" +
				"a dec 586 if ehd >= 1379\n" +
				"z dec 605 if oso >= 4088\n" +
				"oxv dec 168 if hnb >= -1091\n" +
				"uly dec 142 if qur != 6614\n" +
				"eje inc -853 if oso != 4099\n" +
				"xn inc 897 if mf != -3389\n" +
				"kfn dec 79 if yk >= 1894\n" +
				"a inc -562 if hnb == -1082\n" +
				"uly dec -923 if fw <= 4715\n" +
				"ehd dec 104 if fz == 1916\n" +
				"oxv dec -794 if oxv != -1107\n" +
				"hnb inc 786 if qur >= 6609\n" +
				"xn dec -181 if cp >= -4748\n" +
				"oso inc -334 if q > -524\n" +
				"ehd dec 241 if oso == 3763\n" +
				"uly inc -488 if z == -934\n" +
				"kfn inc 873 if fz < 1919\n" +
				"xn inc -999 if hnb == -296\n" +
				"o inc 72 if uly < 1529\n" +
				"oxv dec 727 if q != -512\n" +
				"uly inc -546 if hnb > -302\n" +
				"dl dec 579 if cp != -4756\n" +
				"jf inc -636 if cp < -4743\n" +
				"z inc -116 if mf >= -3395\n" +
				"q dec 339 if kfn > -3093\n" +
				"v inc -273 if oxv == -1831\n" +
				"a dec -410 if qur <= 6618\n" +
				"jf inc 76 if he < -264\n" +
				"oxv inc 689 if oso > 3754\n" +
				"eje dec 163 if q == -525\n" +
				"v inc -613 if v != -5508\n" +
				"xn dec 447 if bkd > -3413\n" +
				"mf inc -128 if o != 4817\n" +
				"ehd dec 690 if b >= 1817\n" +
				"mf dec 737 if b <= 1826\n" +
				"ehd dec -687 if jf == 1110\n" +
				"rny dec -701 if oso >= 3759\n" +
				"a inc 779 if oxv == -1148\n" +
				"dl inc -837 if jf != 1110\n" +
				"dl dec -519 if hnb < -291\n" +
				"dl inc -824 if qur < 6611\n" +
				"fz inc 61 if b <= 1818\n" +
				"cp dec 331 if fz < 1909\n" +
				"fw dec -971 if fz < 1922\n";
		String[] rows = input.split("\n");
		for (String row : rows) {
			Instruction instruction = new Instruction(row);
			instruction.run(registers);
		}
		String highestRegister = "";
		int highestValue = Integer.MIN_VALUE;
		for (String register : registers.base.keySet()) {
			if (registers.get(register) > highestValue) {
				highestRegister = register;
				highestValue = registers.get(register);
			}
		}

		System.out.println(highestRegister + ": " + highestValue);
	}

	static class Instruction {
		private static final String INSTRUCTION_REGEX = "^(\\w+) (inc|dec) (-?\\d+) if (\\w+) (<|<=|>|>=|==|!=) (-?\\d+)$";
		private static final Pattern INSTRUCTION_PATTERN = Pattern.compile(INSTRUCTION_REGEX);

		private Predicate<Registers> condition;
		private Consumer<Registers> action;

		Instruction(String row) {
			Matcher matcher = INSTRUCTION_PATTERN.matcher(row);
			matcher.find();
			String register = matcher.group(1);
			MutationOperator operator = MutationOperator.forCode(matcher.group(2));
			int amount = Integer.parseInt(matcher.group(3));
			String conditionRegister = matcher.group(4);
			ComparisonOperator conditionOperator = ComparisonOperator.forCode(matcher.group(5));
			int conditionAmount = Integer.parseInt(matcher.group(6));

			condition = makeCondition(conditionRegister, conditionOperator, conditionAmount);
			action = makeAction(register, operator, amount);
		}

		void run(Registers registers) {
			if (condition.test(registers)) {
				action.accept(registers);
			}
		}

		private Predicate<Registers> makeCondition(String register, ComparisonOperator operator, int amount) {
			return (registers) -> operator.perform(registers.get(register), amount);
		}

		private Consumer<Registers> makeAction(String register, MutationOperator operator, int amount) {
			return (registers) -> registers.put(register, operator.perform(registers.get(register), amount));
		}
	}

	static class Registers {
		private Map<String, Integer> base;

		Registers() {
			base = new HashMap<>();
		}

		int get(String register) {
			if (!base.containsKey(register)) {
				base.put(register, 0);
			}
			return base.get(register);
		}

		void put(String register, int newValue) {
			base.put(register, newValue);
		}

		@Override
		public String toString() {
			return base.toString();
		}
	}

	enum MutationOperator {
		INC("inc", (current, amount) -> current + amount),
		DEC("dec", (current, amount) -> current - amount);

		private static Map<String, MutationOperator> lookup = new HashMap<>();
		static {
			for(MutationOperator s : MutationOperator.values())
				lookup.put(s.getCode(), s);
		}
		static MutationOperator forCode(String code) {
			return lookup.get(code);
		}

		private BiFunction<Integer, Integer, Integer> action;
		private String code;
		MutationOperator(String code, BiFunction<Integer, Integer, Integer> action) {
			this.action = action;
			this.code = code;
		}

		String getCode() {
			return code;
		}

		int perform(int current, int amount) {
			return action.apply(current, amount);
		}
	}

	enum ComparisonOperator {
		LESS_THAN("<", (current, amount) -> current < amount),
		LESS_THAN_OR_EQUAL("<=", (current, amount) -> current <= amount),
		GREATER_THAN(">", (current, amount) -> current > amount),
		GREATER_THAN_OR_EQUAL(">=", (current, amount) -> current >= amount),
		EQUAL("==", (current, amount) -> current.equals(amount)),
		NOT_EQUAL("!=", (current, amount) -> !current.equals(amount));

		private static Map<String, ComparisonOperator> lookup = new HashMap<>();
		static {
			for(ComparisonOperator s : ComparisonOperator.values())
				lookup.put(s.getCode(), s);
		}
		static ComparisonOperator forCode(String code) {
			return lookup.get(code);
		}

		private BiFunction<Integer, Integer, Boolean> check;
		private String code;
		ComparisonOperator(String code, BiFunction<Integer, Integer, Boolean> check) {
			this.check = check;
			this.code = code;
		}

		String getCode() {
			return code;
		}

		boolean perform(int current, int amount) {
			return check.apply(current, amount);
		}
	}
}
