gnome-terminal --tab -- /bin/bash -c 'cd ZuulGateway; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd EurekaDiscovery; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd AuthenticationService; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd AuthenticationFront; ng serve --ssl; read'
#gnome-terminal --tab -- /bin/bash -c 'cd bank_service; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd bank-service-front; ng serve --ssl; read'
#gnome-terminal --tab -- /bin/bash -c 'cd Bank/bank; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd Bank/bank-front; ng serve --ssl; read'
#gnome-terminal --tab -- /bin/bash -c 'cd Bank/bank2; mvn spring-boot:run; read'
#gnome-terminal --tab -- /bin/bash -c 'cd Bank/pcc; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd scientific_center; mvn spring-boot:run; read'
gnome-terminal --tab -- /bin/bash -c 'cd scientific-center-client; ng serve --ssl; read'
