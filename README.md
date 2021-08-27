[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]


<br />
<p align="center">
  <h1 align="center">Use Prometheus and Grafana to monitor a Spring-Boot application</h1>
</p>


<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#prerequisites">Prerequisites</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


<br />

## About The Project

![Prometheus Monitoring](images/prometheus-scheduled-task-endpoint.PNG?raw=true)

<br/>

![Grafana JVM Dashboard](images/grafana-jvm-dashboard.PNG?raw=true)

<br />

This simple demo project can be used as an example of setup Prometheus and Grafana to monitor a Spring-Boot application. 

The Spring-Boot application is a scheduled task that periodically sends data to console log and micrometer monitoring. And the Prometheus service keeps scraping the data from the exposed actuator prometheus endpoint (http://localhost:8080/actuator/prometheus). Apart from these, the project also contains a demo Grafana dashboard that monitors the JVM information of the Spring-Boot application with JVM (Micrometer). 

<br/>

### Built With

* [Spring-Boot](https://spring.io/projects/spring-boot)
* [Prometheus](https://prometheus.io/)
* [Grafana](https://grafana.com/)
* [Micrometer Prometheus](https://micrometer.io/docs/registry/prometheus)
* [JVM (Micrometer) dashboard for Grafana](https://grafana.com/grafana/dashboards/4701)

<br/>


## Prerequisites 

* install and start Prometheus
  ```sh
  wget https://s3-eu-west-1.amazonaws.com/deb.robustperception.io/41EFC99D.gpg | sudo apt-key add -

  sudo apt-get update -y

  sudo apt-get install prometheus prometheus-node-exporter prometheus-pushgateway prometheus-alertmanager -y

  sudo systemctl start prometheus

  sudo systemctl enable prometheus
  ```

* install and start Grafana
  ```sh
  echo "deb https://packages.grafana.com/oss/deb stable main" | sudo tee -a /etc/apt/sources.list.d/grafana.list

  sudo apt-get update

  sudo apt-get install grafana

  sudo systemctl daemon-reload

  sudo systemctl start grafana-server

  sudo systemctl status grafana-server
  ```
<br />


## Usage

* Spring-Boot app - http://localhost:8080/
* Spring Boot Actuator Prometheus - http://localhost:8080/actuator/prometheus
* Prometheus - http://localhost:9090/
* Grafana - http://localhost:3000/  (default username/password: admin/admin)

<br />

![Spring-Boot Actuator Prometheus endpoint](images/actuator-endpoint.PNG?raw=true)

![Spring-Boot app output](images/scheduled-task-output.PNG?raw=true)

<br/>


## License

Distributed under the MIT License. See `LICENSE` for more information.

<br/>


## Contact
Project Link: [https://github.com/cutePanda123/spring-boot-prometheus-demo](https://github.com/cutePanda123/spring-boot-prometheus-demo)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/cutePanda123/spring-boot-prometheus-demo.svg?style=for-the-badge
[contributors-url]: https://github.com/cutePanda123/spring-boot-prometheus-demo/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/cutePanda123/spring-boot-prometheus-demo.svg?style=for-the-badge
[forks-url]: https://github.com/cutePanda123/spring-boot-prometheus-demo/network/members
[stars-shield]: https://img.shields.io/github/stars/cutePanda123/spring-boot-prometheus-demo.svg?style=for-the-badge
[stars-url]: https://github.com/cutePanda123/spring-boot-prometheus-demo/stargazers
[issues-shield]: https://img.shields.io/github/issues/cutePanda123/spring-boot-prometheus-demo.svg?style=for-the-badge
[issues-url]: https://github.com/cutePanda123/spring-boot-prometheus-demo/issues
[license-shield]: https://img.shields.io/github/license/cutePanda123/spring-boot-prometheus-demo.svg?style=for-the-badge
[license-url]: https://github.com/cutePanda123/spring-boot-prometheus-demo/blob/master/LICENSE.txt

