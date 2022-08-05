cd ../restfm-unit-identification/
. ./fmui.env
nohup java -jar -Xmx1024M fm-ui.jar --spring.profiles.active=dev --spring.config.location=classpath:application-dev.properties --server.port=8228 &
