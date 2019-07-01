#OpenDiabetesVault-Plot
-----------------------

Python script for plotting health data provided by OpenDiabetesVault.

### Dependencies
Plotteria runs on python 3 and utilizes the following libraries:
* matplotlib (>= 3.0.0)
* numpy (>= 1.16.0)
* configparser (>= 3.7.0)
* iso8601 (>= 0.1.10)

### Usage

Call `python plot.py -h` for information how to use the scipt:
```console
Usage: plot.py [OPTION] [FILE ..]

OpenDiabetesVault-Plot v2.0

Options:
  --version             show program's version number and exit
  -h, --help            show this help message and exit
  -f FILE, --data-set=FILE
                        FILE specifies the dataset for the plot.
  -c FILE, --config=FILE
                        FILE specifies configuration file for the plot
                        [Default config.ini].
  -d, --daily           Activates daily plot.
  -s, --dailystatistics
                        Activates daily plot with daily statistics.
  -t FILE, --slice-tiny=FILE
                        FILE specifies slice annotations. Activates slice plot
                        (3 per Line).
  -n FILE, --slice-normal=FILE
                        FILE specifies slice annotations. Activates slice plot
                        (2 per Line).
  -b FILE, --slice-big=FILE
                        FILE specifies slice annotations. Activates slice plot
                        (1 per Line).
  -l, --legend          Activates legend plot.
  -T, --tex             Activates tex file generation.
  -L, --seperatelegend  Activates the seperate legend and deactivates legends
                        within the plot.
  -o PATH, --output-path=PATH
                        PATH specifies the output path for generated files.
                        [Default: ./]
```

#### Example
This command generates the daily plot for a given dataset and creates a detailed legend:
```
python plot.py -f DataSet.csv -d -l
```

Using the `-T` option, the necessary tex files for generating a full report are created along with the daily plots. The generated tex files can then be compiled, e.g. using `pdflatex`:
```
python plot.py -f DataSet.csv -d -l -T
pdflatex report.tex
```


# Docker
We also provide a docker image for running plotteria inside a docker container. All necessary dependencies are included in the provided DockerFile. Additonally, an executable of the script is created using pyinstaller when building the image.

### Build
To build the docker image, use this command inside the root folder of your local plotteria copy.

```sh
$ docker build -t plotteria .
```

### Launch

Use this command to run the plotteria python script inside the docker container. Note that '~/PathTo/plotteria/' needs to be adjusted to match the location of your local plotteria copy.
```sh
$ docker run -v ~/PathTo/plotteria/:/plotteria -w /plotteria/ plotteria python plot.py --help
```

Alternativly, you can launch the executable built by pyinstaller. This might give an additional performance boost in some cases.
```sh
$ docker run -v ~/PathTo/plotteria/:/plotteria -w /plotteria/ plotteria plot --help
```

You can also obtain a permanent shell inside the docker container and run the script from there:
```sh
$ docker run -ti -v ~/PathTo/plotteria/:/plotteria -w /plotteria/ plotteria sh
$ python plot.py --help
$ plot --help
```

For more information about OpenDiabetesVault visit [opendiabetes.de](http://opendiabetes.de).