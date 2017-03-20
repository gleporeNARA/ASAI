# ASAI
Analyzing Spreadsheets with Artificial Intelligence

The current project will work with spreadsheet and database
formats. The program would be written in Java and would use Apache
Tika (https://tika.apache.org/) to identify and analyze all
spreadsheet files (xls, xlsx, ods, csv, and a few other formats) in a
collection. The program would use metadata such as the title of the
file, the names of spreadsheet tabs, the length of the file, and
possibly an analysis of the file's contents, to produce a report for
the processing archivist. The report would be in HTML format, which
would allow us to create various images which illustrate connections
between files and clusters of content.

Tools that will be used for this
project include Google's TensorFlow
(https://www.tensorflow.org/) library for machine intelligence. TensorFlow has the
ability to perform contextual text analysis
(https://research.googleblog.com/2016/08/text-summarization-with-tensorflow.html)
Other tools will perform image
creation, such as the cluster analysis I mentioned above, and other,
simpler things, like word clouds.
